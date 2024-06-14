package dh.backend.clinicaMVC.dao;
import java.util.List;





public  interface IDao <T>{

    T registrar (T t);
    T buscarPorId (Integer id);
    List<T> buscarTodos();

}




//public interface IDao<T> {
//    T registrar(T t);
//    T buscarOdontologo(Integer numero);
//    List<T> listarOdontologo();
//
//    Domicilio buscarPorId(Integer id);
//
//    List<Domicilio> buscarTodos();
//}
//

