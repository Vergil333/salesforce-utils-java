package link.codegen.salesforce.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import link.codegen.salesforce.utils.AbstractSObject;

import java.time.ZonedDateTime;

public class TestObjectMM4__c extends AbstractSObject {

    @JsonProperty("Name") public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @JsonProperty("phone__c") public String phone__c;

    public String getPhone__c() {
        return phone__c;
    }

    public void setPhone__c(String phone__c) {
        this.phone__c = phone__c;
    }

   public TestObjectMM4__c() {
        super("TestObjectMM4__c");
    }
}