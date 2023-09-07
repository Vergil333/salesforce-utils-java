package link.codegen.salesforce.utils;

public class SObjectAttributes {
    public SObjectAttributes(String objectName, String url) {
        this.type = objectName;
        this.url = url;
    }

    String type;
    String url;
}
