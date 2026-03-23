// File: Ship.java
public class Ship {
    String name;
    int length;
    int x, y; // Tọa độ (hàng, cột) của ô đầu tiên
    boolean isHorizontal;
    int hitCount = 0; // Đếm số phát bị bắn trúng

    public Ship(String name, int length) {
        this.name = name;
        this.length = length;
        this.x = -1; // -1 nghĩa là chưa được đặt
        this.y = -1;
        this.isHorizontal = true;
    }

    public void rotate() {
        this.isHorizontal = !this.isHorizontal;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Kiểm tra xem tọa độ (px, py) có nằm trên tàu này không
    public boolean contains(int px, int py) {
        if (x == -1) return false; // Tàu chưa được đặt

        if (isHorizontal) {
            // Tàu nằm ngang: hàng (x) phải giống, cột (y) phải trong khoảng
            return px == this.x && py >= this.y && py < (this.y + this.length);
        } else {
            // Tàu nằm dọc: cột (y) phải giống, hàng (x) phải trong khoảng
            return py == this.y && px >= this.x && px < (this.x + this.length);
        }
    }

    // Tăng số phát bị bắn
    public void registerHit() {
        hitCount++;
    }
    
    // Kiểm tra xem đã chìm chưa
    public boolean isSunk() {
        return hitCount >= length;
    }

    // Lấy chuỗi giao thức cho tàu này
    public String getProtocolString() {
        // Format: length,H/V,x,y
        return String.format("%d,%s,%d,%d",
                this.length,
                (this.isHorizontal ? "H" : "V"),
                this.x,
                this.y);
    }
}