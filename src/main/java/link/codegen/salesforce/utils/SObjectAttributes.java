package link.codegen.salesforce.utils;

public class SObjectAttributes<T extends SObjectType> {
public SObjectAttributes(T type, String url) {
        this.type = type;
        this.url = url;
    }
    T type;
    String url;
}
