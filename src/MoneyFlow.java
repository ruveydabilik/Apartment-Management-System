package src;

import java.util.Date;

public class MoneyFlow {

    private int moneyFlowId;
    private int apartmentId;
    private int residentId;
    private float amount;
    private String description;
    private Date date;
    private int parentId;

    public MoneyFlow(int moneyFlowId, int apartmentId, int residentId, float amount, String description, Date date, int parentId) {
        this.moneyFlowId = moneyFlowId;
        this.apartmentId = apartmentId;
        this.residentId = residentId;
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.parentId = parentId;
    }

    public MoneyFlow(int apartmentId, int residentId, float amount, String description, Date date, int parentId) {
        this.apartmentId = apartmentId;
        this.residentId = residentId;
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.parentId = parentId;
    }

    public int getMoneyFlowId() {
        return moneyFlowId;
    }

    public void setMoneyFlowId(int moneyFlowId) {
        this.moneyFlowId = moneyFlowId;
    }

    public int getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }

    public int getResidentId() {
        return residentId;
    }

    public void setResidentId(int residentId) {
        this.residentId = residentId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public Object getByName(String attributeName) {
        switch (attributeName) {
            case "MoneyFlowId":
                return moneyFlowId;
            case "ApartmentId":
                return apartmentId;
            case "ResidentId":
                return residentId;
            case "Amount":
                return amount;
            case "Description":
                return description;
            case "Date":
                return date;
            case "ParentId":
                return parentId;
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return "MoneyFlow{" +
                "moneyFlowId=" + moneyFlowId +
                ", apartmentId=" + apartmentId +
                ", residentId=" + residentId +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", parentId=" + parentId +
                '}';
    }
}
