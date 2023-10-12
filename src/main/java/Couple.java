public class Couple {
    public String nameBoy, nameGirl, lastName, idStudent, fechaRegistro;
    public int age;

    public Couple(String nameBoy, String nameGirl, String lastName, String idStudent, String fechaRegistro, int age) {
        this.nameBoy = nameBoy;
        this.nameGirl = nameGirl;
        this.lastName = lastName;
        this.idStudent = idStudent;
        this.fechaRegistro = fechaRegistro;
        this.age = age;
    }

    public String getNameBoy() {
        return nameBoy;
    }

    public void setNameBoy(String nameBoy) {
        this.nameBoy = nameBoy;
    }

    public String getNameGirl() {
        return nameGirl;
    }

    public void setNameGirl(String nameGirl) {
        this.nameGirl = nameGirl;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
