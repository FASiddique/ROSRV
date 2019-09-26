package rosmop.parser.ast;

import java.util.Arrays;
import java.util.List;

public class CFunction {
    private final String returnType;
    private final String name;
    private final List<Parameter> params;
    private final String content;

    public CFunction(String returnType, String name, List<Parameter> params, String content) {
        this.returnType = returnType;
        this.name = name;
        this.params = params;
        this.content = content;
    }

    public String getReturnType() {
        return returnType;
    }

    public String getName() {
        return name;
    }

    public List<Parameter> getParams() {
        return params;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
       StringBuffer buffer = new StringBuffer();
       buffer.append(returnType + " " + name + "(");
       if(!params.isEmpty()) {
           buffer.append(params.get(0));
           for (Parameter param : this.params.subList(1, params.size())) {
               buffer.append(" ," + param);
           }
       }
       buffer.append(") \n");

       String[] stringArray = content.split("\n");
       for(int i = 0; i < stringArray.length; ++i) {
           if(i == stringArray.length - 1) {
              buffer.append(stringArray[i].trim() + "\n");
           } else {
               buffer.append(stringArray[i] + "\n");
           }
       }
       return buffer.toString();
    }
}