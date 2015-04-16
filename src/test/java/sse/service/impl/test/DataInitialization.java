////package sse.service.impl.test;
////
////import java.util.ArrayList;
////import java.util.List;
////
////import org.junit.Test;
////
////import sse.entity.Student;
////import sse.entity.Teacher;
////import sse.entity.User;
////import sse.entity.Will;
////import sse.entity.WillPK;
////
////public class DataInitialization extends BaseJPATest {
////
////    public int fbn(String name)
////    {
////        return ((User)(em.createQuery("select u from User u where u.name=:name").setParameter("name", name)
////                .getResultList().get(0))).getId();
////    }
////
////    @Test
////    public void test() {
////        int numOfStudent = 7;
////        System.out.println("Hloo");
////
////        System.out.println(fbn("YuesongWang"));
////        beginTransaction();
////        String p = "Initial0";
////        Student yuesongWang = new Student(1, "1152754", "YuesongWang", p);
////        em.persist(yuesongWang);
////        Student leiYang = new Student(2, "1152755", "LeiYang", p);
////        em.persist(leiYang);
////        Student JunyaoZhao = new Student(3, "1152756", "JunyaoZhao", p);
////        em.persist(JunyaoZhao);
////        Student ZenanHu = new Student(4, "1152757", "ZenanHu", p);
////        em.persist(ZenanHu);
////        Student BoyiLi = new Student(5, "1152759", "BoyiLi", p);
////        em.persist(BoyiLi);
////        Student YifanZhang = new Student(6, "1152760", "YifanZhang", p);
////        em.persist(YifanZhang);
////
////        Teacher yanLiu = new Teacher(7, "1252753", "YanLiu", p, 3);
////        em.persist(yanLiu);
////        Teacher pingSun = new Teacher(8, "1252754", "PingSun", p, 2);
////        em.persist(pingSun);
////        Teacher dongQingWang = new Teacher(9, "1252755", "DongqingWang", p, 5);
////        em.persist(dongQingWang);
////        Teacher changQingYin = new Teacher(10, "1252756", "ChangqingYin", p, 2);
////        em.persist(changQingYin);
////        Teacher meihuiLi = new Teacher(11, "1252757", "MeihuiLi", p, 2);
////        em.persist(meihuiLi);
////
////        List<Will> willList = new ArrayList<Will>();
////        // Yuesong Wang
////        willList.add(new Will(new WillPK(fbn("YuesongWang"), fbn("YanLiu")), 1));
////        willList.add(new Will(new WillPK(fbn("YuesongWang"), fbn("PingSun")), 2));
////        willList.add(new Will(new WillPK(fbn("YuesongWang"), fbn("dongqingWang")), 3));
////        // LeiYang
////        willList.add(new Will(new WillPK(fbn("LeiYang"), fbn("MeihuiLi")), 1));
////        willList.add(new Will(new WillPK(fbn("LeiYang"), fbn("ChangqingYin")), 2));
////        // JunYao zhao
////        willList.add(new Will(new WillPK(fbn("JunyaoZhao"), fbn("YanLiu")), 1));
////        willList.add(new Will(new WillPK(fbn("JunyaoZhao"), fbn("ChangqingYin")), 2));
////        willList.add(new Will(new WillPK(fbn("JunyaoZhao"), fbn("PingSun")), 3));
////        // Zenan hu
////        willList.add(new Will(new WillPK(fbn("ZenanHu"), fbn("YanLiu")), 1));
////        willList.add(new Will(new WillPK(fbn("ZenanHu"), fbn("PingSun")), 2));
////        willList.add(new Will(new WillPK(fbn("ZenanHu"), fbn("DongqingWang")), 3));
////        // Boyi li
////        willList.add(new Will(new WillPK(fbn("BoyiLi"), fbn("PingSun")), 1));
////        willList.add(new Will(new WillPK(fbn("BoyiLi"), fbn("DongqingWang")), 2));
////        willList.add(new Will(new WillPK(fbn("BoyiLi"), fbn("DongqingWang")), 3));
////        // Yifan Zhang
////        willList.add(new Will(new WillPK(6, 7), 1));
////        willList.add(new Will(new WillPK(6, 8), 2));
////        willList.add(new Will(new WillPK(6, 11), 3));
////
////        for (Will w : willList)
////        {
////            em.persist(w);
////        }
////        commitTransaction();
////
////    }
////
////}
//
//package sse.service.impl.test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//
//import sse.entity.Menu;
//import sse.entity.Student;
//import sse.entity.Teacher;
//import sse.entity.User;
//import sse.entity.Will;
//import sse.entity.WillPK;
//
//public class DataInitialization extends BaseJPATest {
//
//    public int fbn(String name)
//    {
//        return ((User) (em.createQuery("select u from User u where u.name=:name").setParameter("name", name)
//                .getResultList().get(0))).getId();
//    }
//
//    public int menufbn(String name)
//    {
//        return ((Menu) (em.createQuery("select m from Menu m where m.name=:name").setParameter("name", name)
//                .getResultList().get(0))).getId();
//    }
//
//    @Test
//    public void test() {
//        System.out.println("Start");
//        beginTransaction();
//        String p = "Initial0";
//        Student yuesongWang = new Student(1, "1152754", "王岳松", p);
//        em.persist(yuesongWang);
//        Student leiYang = new Student(2, "1152755", "杨磊", p);
//        em.persist(leiYang);
//        Student JunyaoZhao = new Student(3, "1152756", "赵俊尧", p);
//        em.persist(JunyaoZhao);
//        Student ZenanHu = new Student(4, "1152757", "胡泽南", p);
//        em.persist(ZenanHu);
//        Student BoyiLi = new Student(5, "1152759", "李博一", p);
//        em.persist(BoyiLi);
//        Student YifanZhang = new Student(6, "1152760", "张一帆", p);
//        em.persist(YifanZhang);
//
//        Teacher yanLiu = new Teacher(7, "1252753", "刘岩", p, 3);
//        em.persist(yanLiu);
//        Teacher pingSun = new Teacher(8, "1252754", "孙萍", p, 2);
//        em.persist(pingSun);
//        Teacher dongQingWang = new Teacher(9, "1252755", "王冬青", p, 5);
//        em.persist(dongQingWang);
//        Teacher changQingYin = new Teacher(10, "1252756", "尹长青", p, 2);
//        em.persist(changQingYin);
//        Teacher meihuiLi = new Teacher(11, "1252757", "李美惠", p, 2);
//        em.persist(meihuiLi);
//
//        List<Will> willList = new ArrayList<Will>();
//        // Yuesong Wang
//        willList.add(new Will(new WillPK(fbn("王岳松"), fbn("刘岩")), 1));
//        willList.add(new Will(new WillPK(fbn("王岳松"), fbn("孙萍")), 2));
//        willList.add(new Will(new WillPK(fbn("王岳松"), fbn("王冬青")), 3));
//        // LeiYang
//        willList.add(new Will(new WillPK(fbn("杨磊"), fbn("李美惠")), 1));
//        willList.add(new Will(new WillPK(fbn("杨磊"), fbn("尹长青")), 2));
//        // JunYao zhao
//        willList.add(new Will(new WillPK(fbn("赵俊尧"), fbn("刘岩")), 1));
//        willList.add(new Will(new WillPK(fbn("赵俊尧"), fbn("尹长青")), 2));
//        willList.add(new Will(new WillPK(fbn("赵俊尧"), fbn("孙萍")), 3));
//        // Zenan hu
//        willList.add(new Will(new WillPK(fbn("胡泽南"), fbn("刘岩")), 1));
//        willList.add(new Will(new WillPK(fbn("胡泽南"), fbn("孙萍")), 2));
//        willList.add(new Will(new WillPK(fbn("胡泽南"), fbn("王冬青")), 3));
//        // Boyi li
//        willList.add(new Will(new WillPK(fbn("李博一"), fbn("孙萍")), 1));
//        willList.add(new Will(new WillPK(fbn("李博一"), fbn("王冬青")), 2));
//        willList.add(new Will(new WillPK(fbn("李博一"), fbn("刘岩")), 3));
//        // Yifan Zhang
//        willList.add(new Will(new WillPK(fbn("张一帆"), fbn("刘岩")), 1));
//        willList.add(new Will(new WillPK(fbn("张一帆"), fbn("孙萍")), 2));
//        willList.add(new Will(new WillPK(fbn("张一帆"), fbn("李美惠")), 3));
//
//        for (Will w : willList)
//        {
//            em.persist(w);
//        }
//
//        List<Menu> menus = new ArrayList<Menu>();
//        em.persist(new Menu(1, "指导教师", null, "Student", ""));
//        menus.add(new Menu(2, "所有老师", menufbn("指导教师"), "Student",
//                "http://localhost:8080/sse/dispatch/student/all_teachers"));
//        menus.add(new Menu(3, "填报志愿", menufbn("指导教师"), "Student",
//                "http://localhost:8080/sse/dispatch/student/select_will"));
//        menus.add(new Menu(4, "我的老师", menufbn("指导教师"), "Student", ""));
//
//        for (Menu m : menus)
//        {
//            em.persist(m);
//        }
//        menus = new ArrayList<Menu>();
//        em.persist(new Menu(5, "我的文档", null, "Student", ""));
//        menus.add(new Menu(6, "开题报告", menufbn("我的文档"), "Student", ""));
//        menus.add(new Menu(7, "中期自查", menufbn("我的文档"), "Student", ""));
//        for (Menu m : menus)
//        {
//            em.persist(m);
//        }
//        commitTransaction();
//        System.out.println("Finished");
//    }
//
//}
