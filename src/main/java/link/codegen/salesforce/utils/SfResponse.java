package link.codegen.salesforce.utils;

import java.util.List;

public class SfResponse<T extends SObjectInterface> {
    private Integer totalSize;
    private Boolean done;
    private List<T> records;

    public Integer getTotalSize() {
        return totalSize;
    }

    public Boolean getDone() {
        return done;
    }

    public List<T> getRecords() {
        return records;
    }
}
