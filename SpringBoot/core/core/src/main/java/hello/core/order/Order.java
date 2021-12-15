package hello.core.order;

public class Order {

    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int disocuntPrice;

    public Order(Long memberId, String itemName, int itemPrice, int disocuntPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.disocuntPrice = disocuntPrice;
    }

    public int calculatorPrice(){
        return itemPrice - disocuntPrice;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDisocuntPrice() {
        return disocuntPrice;
    }

    public void setDisocuntPrice(int disocuntPrice) {
        this.disocuntPrice = disocuntPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", disocuntPrice=" + disocuntPrice +
                '}';
    }
}
