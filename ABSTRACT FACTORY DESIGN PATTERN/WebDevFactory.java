public class WebDevFactory extends EmployeeAbstractFactory{

    @Override
    public Employee creatEmployee() {
        return new WebDeveloper();
    }
    
}
