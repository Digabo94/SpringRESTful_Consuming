package RESTful.RESTful;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Con esta anotacion se ignoran otros valores de la peticion JSON que no se encuentren dentro de esta clase
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
    
    private String type;
    private Value value;
    
    public Quote(){
    }
    
    public String getType(){
        return this.type;
    }
    
    public void setType(String type){
        this.type = type;
    }
    
    public Value getValue(){
        return this.value;
    }
    
    public void setValue(Value value){
        this.value = value;
    }
    
    
    @Override
    public String toString(){
        return "Quote{" +
                "type='" + this.type + '\'' +
                ", value=" + value + '}';
    }
                
    }
