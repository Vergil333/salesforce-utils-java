package link.codegen.salesforce.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import link.codegen.salesforce.utils.AbstractSObject;

/**
 * @property email__c Email
 * @property name Text(80)
 * @property orderBookAsk__c Text(32), This field should be parsed as OrderBookAsk and not Order_Book_Ask__c (bugfix)
 */
public class TestObject__c extends AbstractSObject {
    @JsonProperty("email__c") public String email__c;

    public String getEmail__c() {
        return email__c;
    }

    public void setEmail__c(String email__c) {
        this.email__c = email__c;
    }

    @JsonProperty("Name") public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("OrderBookAsk__c") public String orderBookAsk__c;

    public String getOrderBookAsk__c() {
        return orderBookAsk__c;
    }

    public void setOrderBookAsk__c(String orderBookAsk__c) {
        this.orderBookAsk__c = orderBookAsk__c;
    }

   public TestObject__c() {
        super("TEST_OBJECT__C");
    }
}
