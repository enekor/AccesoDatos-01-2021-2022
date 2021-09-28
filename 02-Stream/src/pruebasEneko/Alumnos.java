package pruebasEneko;

import es.joseluisgs.dam.model.Alumno;
//import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Alumnos {

    List<Alumno> listaAlumnos = new ArrayList<>();

    public Alumnos(){
        aniadirAlumnos();
    }

    public void aniadirAlumnos(){
        listaAlumnos.add(new Alumno(1, "1717213183", "Javier", "Molina Cano", "Java 8", 7, 28));
        listaAlumnos.add(new Alumno(2, "1717456218", "Ana", "Gómez Álvarez", "Java 8", 10, 33));
        listaAlumnos.add(new Alumno(3, "1717328901", "Pedro", "Marín López", "Java 8", 8.6, 15));
        listaAlumnos.add(new Alumno(4, "1717567128", "Emilio", "Duque Gutiérrez", "Java 8", 10, 13));
        listaAlumnos.add(new Alumno(5, "1717902145", "Alberto", "Sáenz Hurtado", "Java 8", 9.5, 15));
        listaAlumnos.add(new Alumno(6, "1717678456", "Germán", "López Fernández", "Java 8", 8, 34));
        listaAlumnos.add(new Alumno(7, "1102156732", "Oscar", "Murillo González", "Java 8", 10, 32));
        listaAlumnos.add(new Alumno(8, "1103421907", "Antonio Jesús", "Palacio Martínez", "PHP", 9.5, 17));
        listaAlumnos.add(new Alumno(9, "1717297015", "César", "González Martínez", "Java 8", 8, 26));
        listaAlumnos.add(new Alumno(10, "1717912056", "Gloria", "González Castaño", "PHP", 10, 28));
        listaAlumnos.add(new Alumno(11, "1717912058", "Jorge", "Ruiz Ruiz", "Python", 8, 22));
        listaAlumnos.add(new Alumno(12, "1717912985", "Ignacio", "Duque García", "Java Script", 9.4, 32));
        listaAlumnos.add(new Alumno(13, "1717913851", "Julio", "González Castaño", "C Sharp", 10, 22));
        listaAlumnos.add(new Alumno(14, "1717986531", "Gloria", "Rodas Carretero", "Ruby", 7, 18));
        listaAlumnos.add(new Alumno(15, "1717975232", "Jaime", "Jiménez Gómez", "Java Script", 10, 18));

    }

    public void listaAlumnos(){
        System.out.println("--- alumnos---");
        listaAlumnos.forEach(System.out::println);

        System.out.println("\n--- alumnos que empiezan por A o J");
        listaAlumnos.stream().filter(a -> a.getNombre().toLowerCase().startsWith("a") || a.getNombre().toLowerCase().startsWith("j"))
                .forEach(System.out::println);

        System.out.println("\n--- numero de alumnos ---");
        System.out.println(listaAlumnos.stream().count());

        System.out.println("\n--- Alumnos con nota mayor a 8 y que sean alumnos de java ---");
        listaAlumnos.stream().filter(a -> a.getNombreCurso().equals("Java 8") && a.getNota()>8)
                .forEach(System.out::println);

        System.out.println("\n--- primeros alumnos de la lista que esten apuntados a PHP ---");
        listaAlumnos.stream().filter(a -> a.getNombreCurso().equals("PHP"))
                .limit(2).forEach(System.out::println);

        System.out.println("\n---Alumno con mayor edad ---");
        System.out.println(listaAlumnos.stream().max(Comparator.comparingInt(Alumno::getEdad)));

        System.out.println("\n--- Alumno con menor edad ---");
        System.out.println(listaAlumnos.stream().min((a1, a2) -> a1.getEdad()-a2.getEdad()));

        System.out.println("\n--- Primer alumno ---");
        System.out.println(listaAlumnos.stream().findFirst());

        System.out.println("\n--- Alumnos que esten en una clase que contenga la letra P ---");
        listaAlumnos.stream().filter(a -> a.getNombreCurso().toLowerCase().contains("p")).forEach(System.out::println);

        System.out.println("\n --- Alumnos que la longitud de su nombre es mayor a 5 caracteres ---");
        listaAlumnos.stream().filter(a -> a.getNombre().length()>5).forEach(System.out::println);

        System.out.println("\n--- Combinacion de predicados ---");
        Predicate<Alumno> tamanioNombre = a -> a.getNombre().length()>5;
        Predicate<Alumno> cursoJavaScript = a -> a.getNombreCurso().equalsIgnoreCase("Java Script");
        listaAlumnos.stream().filter(tamanioNombre.and(cursoJavaScript)).forEach(System.out::println);

        System.out.println("\n--- Migramos una lista de alumnos que contienen la a en el nombre a otra lista ---");
        List<Alumno> alumnosModificado = new ArrayList<>();
        alumnosModificado=listaAlumnos.stream().filter(a -> a.getNombre().toLowerCase().contains("a")).collect(Collectors.toList());
        alumnosModificado.stream().forEach(System.out::println);


        System.out.println("\n--- Ningun alumno tiene la z en su nombre ---");
        Predicate<Alumno> tieneZ = a -> a.getNombre().toLowerCase().contains("z");
        System.out.println(listaAlumnos.stream().noneMatch(tieneZ));

    }


}
