import java.util.Scanner;

public class todolistApp {

    // Menggunakan tipe data array
    public static String[] modelTodo = new String[10];

    // Membuat object scanner
    public static java.util.Scanner scan = new Scanner(System.in);

    /**
     * Method main
     * @param args
     */
    public static void main(String[] args) {
       viewShowTodo();

    }

    /**
     * Membuat bussiness logic
     */

    // Logic menampilkan Todolist
    public static void showTodo(){
        System.out.println("TODO LIST");
        System.out.println("==========");
        for (var i = 0; i < modelTodo.length; i++) {
            var todo = modelTodo[i];
            var nomor = 1 + i;

            if(todo != null){
                System.out.println(nomor + ". " + todo);
            }
        }

    }

    // Logic menambah Todolist
    public static void addTodo(String todo){

        // Cek jika apakah model sudah penuh
        var penuh = true;
        for (int i = 0; i < modelTodo.length; i++){
            // model masih ada yang kosong
            if(modelTodo[i] == null){
                penuh = false;
                break;
            }
        }

        // Jika model penuh maka model di resize
        if(penuh){
            var temp = modelTodo; // penyimpanan sementara agar data tidak hilang setelah di resize
            modelTodo = new String[modelTodo.length * 2]; // resize 2x lipat

            for(int i = 0; i < temp.length; i++){
                modelTodo[i] = temp[i];
            }
        }


        // Tambah data ke posisi array yg NULL
        for (var i = 0; i < modelTodo.length; i++){
            if(modelTodo[i] == null){
                modelTodo[i] = todo;
                break;
            }
        }

    }

    // Logic menghapus Todolist
    public static boolean removeTodo(Integer nomor){
        if((nomor - 1) >= modelTodo.length){
            return false;
        } else if (modelTodo[nomor - 1] == null){
            return false;
        } else {
            for(int i = (nomor - 1); i < modelTodo.length; i++){
               if(i == (modelTodo.length) - 1){
                   modelTodo[i] = null;
               }else {
                   modelTodo[i] = modelTodo[i + 1];
               }
            }
            return true;
        }

    }

    /**
     * Membuat input
     */
    public static String input (String info){
        System.out.print(info + ": ");
        String data = scan.nextLine();
        return data;
    }


    /**
     * Membuat view/tampilan untuk aplikasi
     */

    // View tampilan Todolist
    public static void viewShowTodo(){
        while (true) {
            showTodo();

            System.out.println("MENU : ");
            System.out.println("1. Tambah ");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");

            if (input.equals("1")) {
                viewAddTodo();
            } else if (input.equals("2")) {
                viewRemoveTodo();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan salah, ulangi");
            }

        }

    }

    // View tampilan tambah Todolist
    public static void viewAddTodo(){
        System.out.println("TAMBAH TODO LIST");

        var todo = input("Todo");

        if(todo.equals("x")){
            // batal
        } else {
            addTodo(todo);
        }

    }

    // View tampilan hapus Todolist
    public static void viewRemoveTodo(){
        System.out.println("HAPUS TODO LIST");

        var nomor = input("Hapus");

        if(nomor.equals("x")){
            // batal
        } else {
            boolean sukses = removeTodo(Integer.valueOf(nomor));
            if(!sukses){
                System.out.println("Gagal menghapus : " + nomor);
            }
        }

    }

    /**
     * Method untuk test logic yang sudah dibuat
     */
    public static void testTodo(){
        showTodo();
    }
    public static void testAddTodo(){
        for(int i = 0; i <11; i++){
            addTodo("Todo ke-" + i);
        }

        showTodo();
    }
    public static void testRemoveTodo(){
        addTodo("satu");
        addTodo("dua");
        addTodo("tiga");
        addTodo("empat");
        addTodo("lima");

        var hasil = removeTodo(20);
        System.out.println(hasil);

        hasil = removeTodo(7);
        System.out.println(hasil);

        hasil = removeTodo(2);
        System.out.println(hasil);

        showTodo();
    }
    public static void testInput(){
        var nama = input("Masukan Nama");
        System.out.println("Halo, " + nama);
    }
    public static void testViewTodo(){
        addTodo("satu");
        addTodo("dua");
        addTodo("tiga");
        addTodo("empat");
        addTodo("lima");
        viewShowTodo();
    }
    public static void testViewAddTodo(){
        viewAddTodo();
        showTodo();
    }
    public static void testViewRemoveTodo(){
        addTodo("satu");
        addTodo("dua");
        addTodo("tiga");
        addTodo("empat");
        addTodo("lima");
        showTodo();
        viewRemoveTodo();
        showTodo();
    }

}
