package objecttransformer;

import java.io.Serializable;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;


public class ConTransfo implements Transformer, Serializable {
	public static final long serialVersionUID = 2301440726369055124L;
	public static final Transformer NULL_INSTANCE = new ConTransfo(null);
	public Object iConstant;
	
	public ConTransfo(Object constantToReturn) {
		super();
		iConstant = constantToReturn;
	}
	
	public Object transform(Object input) {
        return iConstant;
    }
	
	
}
