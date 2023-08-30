package link.codegen.salesforce.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SObjectType {
    @JsonProperty("Account") ACCOUNT("Account"),
    @JsonProperty("TestObjectMM4__c") TEST_OBJECT_MM4__C("TestObjectMM4__c"),
    ;

    SObjectType(String jsonName) {}
}
