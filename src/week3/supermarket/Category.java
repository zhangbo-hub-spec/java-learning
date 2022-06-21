package week3.supermarket;

public enum Category {

    // >> TODO 必须在开始的时候以这种形式，创建所有的枚举对象
    FOOD(1),
    GAMES(3),
    PHONE(5),

    CPU(7);





    // 可以有属性
    private int id;

    // >> TODO 构造方法必须是private的，不写也是private的
    Category(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }


    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                '}';
    }

}
