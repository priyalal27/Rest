package SerializationDeserialization;

import java.util.List;

public class ParentPojo {


    private String status;

    private List<DataPojo> data_value;

    public List<DataPojo> getData_value() {
        return data_value;
    }

    public void setData_value(List<DataPojo> data_value) {
        this.data_value = data_value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
