package ucu.edu.aed.ejercicio24;

public class Alumno {
    private int id;
    private String name;
    private String apellido;

    public Alumno(int id, String name, String apellido){
        this.id = id;
        this.name = name;
        this.apellido = apellido;
    }

    public int getId(){return id;}
    public String getName(){return name;}
    public String getApellido(){return apellido;}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Alumno)) return false;
        Alumno otro = (Alumno) obj;
        return this.id == otro.id;
    }

    @Override
    public String toString() {
        return id + " - " + name + " " + apellido;
    }
}


