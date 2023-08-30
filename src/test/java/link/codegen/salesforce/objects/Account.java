package link.codegen.salesforce.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import link.codegen.salesforce.utils.AbstractSObject;
import link.codegen.salesforce.utils.SObjectType;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Map;

public class Account extends AbstractSObject {
    @JsonProperty("AccountNumber") public String accountNumber;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @JsonProperty("AccountSource") public String accountSource;

    public String getAccountSource() {
        return accountSource;
    }

    public void setAccountSource(String accountSource) {
        this.accountSource = accountSource;
    }

    @JsonProperty("Active__c") public String active__c;

    public String getActive__c() {
        return active__c;
    }

    public void setActive__c(String active__c) {
        this.active__c = active__c;
    }

    @JsonProperty("AnnualRevenue") public Double annualRevenue;

    public Double getAnnualRevenue() {
        return annualRevenue;
    }

    public void setAnnualRevenue(Double annualRevenue) {
        this.annualRevenue = annualRevenue;
    }

    @JsonProperty("BillingAddress") public Map<String, Object> billingAddress;

    public Map<String, Object> getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Map<String, Object> billingAddress) {
        this.billingAddress = billingAddress;
    }

    @JsonProperty("CleanStatus") public String cleanStatus;

    public String getCleanStatus() {
        return cleanStatus;
    }

    public void setCleanStatus(String cleanStatus) {
        this.cleanStatus = cleanStatus;
    }


    @JsonProperty("CustomerPriority__c") public String customerPriority__c;

    public String getCustomerPriority__c() {
        return customerPriority__c;
    }

    public void setCustomerPriority__c(String customerPriority__c) {
        this.customerPriority__c = customerPriority__c;
    }

    @JsonProperty("DandbCompanyId") public String dandbCompanyId;

    public String getDandbCompanyId() {
        return dandbCompanyId;
    }

    public void setDandbCompanyId(String dandbCompanyId) {
        this.dandbCompanyId = dandbCompanyId;
    }

    @JsonProperty("Description") public String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("DunsNumber") public String dunsNumber;

    public String getDunsNumber() {
        return dunsNumber;
    }

    public void setDunsNumber(String dunsNumber) {
        this.dunsNumber = dunsNumber;
    }

    @JsonProperty("Fax") public String fax;

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @JsonProperty("Industry") public String industry;

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @JsonProperty("Jigsaw") public String jigsaw;

    public String getJigsaw() {
        return jigsaw;
    }

    public void setJigsaw(String jigsaw) {
        this.jigsaw = jigsaw;
    }

    @JsonProperty("JigsawCompanyId") public String jigsawCompanyId;

    public String getJigsawCompanyId() {
        return jigsawCompanyId;
    }

    public void setJigsawCompanyId(String jigsawCompanyId) {
        this.jigsawCompanyId = jigsawCompanyId;
    }

    @JsonProperty("LastActivityDate") public LocalDate lastActivityDate;

    public LocalDate getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(LocalDate lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    @JsonProperty("LastReferencedDate") public ZonedDateTime lastReferencedDate;

    public ZonedDateTime getLastReferencedDate() {
        return lastReferencedDate;
    }

    public void setLastReferencedDate(ZonedDateTime lastReferencedDate) {
        this.lastReferencedDate = lastReferencedDate;
    }

    @JsonProperty("LastViewedDate") public ZonedDateTime lastViewedDate;

    public ZonedDateTime getLastViewedDate() {
        return lastViewedDate;
    }

    public void setLastViewedDate(ZonedDateTime lastViewedDate) {
        this.lastViewedDate = lastViewedDate;
    }

    @JsonProperty("MasterRecordId") public String masterRecordId;

    public String getMasterRecordId() {
        return masterRecordId;
    }

    public void setMasterRecordId(String masterRecordId) {
        this.masterRecordId = masterRecordId;
    }

    @JsonProperty("NaicsCode") public String naicsCode;

    public String getNaicsCode() {
        return naicsCode;
    }

    public void setNaicsCode(String naicsCode) {
        this.naicsCode = naicsCode;
    }

    @JsonProperty("NaicsDesc") public String naicsDesc;

    public String getNaicsDesc() {
        return naicsDesc;
    }

    public void setNaicsDesc(String naicsDesc) {
        this.naicsDesc = naicsDesc;
    }

    @JsonProperty("Name") public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("NumberOfEmployees") public Double numberOfEmployees;

    public Double getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Double numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @JsonProperty("NumberofLocations__c") public Double numberofLocations__c;

    public Double getNumberofLocations__c() {
        return numberofLocations__c;
    }

    public void setNumberofLocations__c(Double numberofLocations__c) {
        this.numberofLocations__c = numberofLocations__c;
    }

    @JsonProperty("OperatingHoursId") public String operatingHoursId;

    public String getOperatingHoursId() {
        return operatingHoursId;
    }

    public void setOperatingHoursId(String operatingHoursId) {
        this.operatingHoursId = operatingHoursId;
    }

    @JsonProperty("Ownership") public String ownership;

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    @JsonProperty("ParentId") public Map<String, Object> parentId;

    public Map<String, Object> getParentId() {
        return parentId;
    }

    public void setParentId(Map<String, Object> parentId) {
        this.parentId = parentId;
    }

    @JsonProperty("Phone") public String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("PhotoUrl") public String photoUrl;

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @JsonProperty("Rating") public String rating;

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @JsonProperty("SLAExpirationDate__c") public LocalDate sLAExpirationDate__c;

    public LocalDate getSLAExpirationDate__c() {
        return sLAExpirationDate__c;
    }

    public void setSLAExpirationDate__c(LocalDate sLAExpirationDate__c) {
        this.sLAExpirationDate__c = sLAExpirationDate__c;
    }

    @JsonProperty("SLASerialNumber__c") public String sLASerialNumber__c;

    public String getSLASerialNumber__c() {
        return sLASerialNumber__c;
    }

    public void setSLASerialNumber__c(String sLASerialNumber__c) {
        this.sLASerialNumber__c = sLASerialNumber__c;
    }

    @JsonProperty("SLA__c") public String sLA__c;

    public String getSLA__c() {
        return sLA__c;
    }

    public void setSLA__c(String sLA__c) {
        this.sLA__c = sLA__c;
    }

    @JsonProperty("ShippingAddress") public Map<String, Object> shippingAddress;

    public Map<String, Object> getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Map<String, Object> shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @JsonProperty("Sic") public String sic;

    public String getSic() {
        return sic;
    }

    public void setSic(String sic) {
        this.sic = sic;
    }

    @JsonProperty("SicDesc") public String sicDesc;

    public String getSicDesc() {
        return sicDesc;
    }

    public void setSicDesc(String sicDesc) {
        this.sicDesc = sicDesc;
    }

    @JsonProperty("Site") public String site;

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @JsonProperty("TickerSymbol") public String tickerSymbol;

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    @JsonProperty("Tradestyle") public String tradestyle;

    public String getTradestyle() {
        return tradestyle;
    }

    public void setTradestyle(String tradestyle) {
        this.tradestyle = tradestyle;
    }

    @JsonProperty("Type") public String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("UpsellOpportunity__c") public String upsellOpportunity__c;

    public String getUpsellOpportunity__c() {
        return upsellOpportunity__c;
    }

    public void setUpsellOpportunity__c(String upsellOpportunity__c) {
        this.upsellOpportunity__c = upsellOpportunity__c;
    }

    @JsonProperty("Website") public String website;

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @JsonProperty("YearStarted") public String yearStarted;

    public String getYearStarted() {
        return yearStarted;
    }

    public void setYearStarted(String yearStarted) {
        this.yearStarted = yearStarted;
    }

   public Account() {
        super(SObjectType.ACCOUNT);
    }
}
