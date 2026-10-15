public class ReceiptPrinterVisitor implements Visitor{
    private StringBuilder receipt;

    public ReceiptPrinterVisitor(){
        this.receipt = new StringBuilder();
        receipt.append("RECEIPT\n");
    }

    public void visitBook(Book book){
        appendItem("[BOOK] " + book.getName(), book.getBasePrice());
    }

    public void visitClothing(Clothing clothing){
        appendItem("[CLOTHING] " + clothing.getName(), clothing.getBasePrice());
    }

    public void visitFood(Food food){
        appendItem("[FOOD] " + food.getName(), food.getBasePrice());
    }

    private void appendItem(String label, double price){
        receipt.append(label).append(": $").append(String.format("%.2f", price)).append("\n");
    }

    public String getReceipt(){
        return receipt.toString() + "\n";
    }
}
