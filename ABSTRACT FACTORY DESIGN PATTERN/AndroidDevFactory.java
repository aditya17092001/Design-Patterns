public class AndroidDevFactory extends EmployeeAbstractFactory{

    @Override
    public Employee creatEmployee() {
        return new AndroidDeveloper();
    }
    
}
