package ProjectClass;

public class ProjectTest {
    public static void main(String[] args) {

        Project p1 = new Project();
        Project p2 = new Project("Checkers");
        Project p3 = new Project("Pinky", "Take over the world!");
        Project p4 = new Project("Project X = ", "This is project 1");

        Portfolio myPortfolio = new Portfolio();

        System.out.println(p1.elevatorPitch());
        System.out.println(p2.elevatorPitch());
        System.out.println(p3.elevatorPitch());
        System.out.println(p4.elevatorPitch());

        p1.setName("Range Rover");
        p1.setDescription("Come here");

        System.out.println(p1.elevatorPitch());
        System.out.println(p2.getName());

        p1.setInitialCost(1.25);
        p2.setInitialCost(1000);

        System.out.println(p1.elevatorPitch());
        System.out.println(p2.elevatorPitch());

        myPortfolio.AddToPortfolio(p1);
        myPortfolio.AddToPortfolio(p2);
        myPortfolio.AddToPortfolio(p3);

        System.out.println(myPortfolio.getPortfolio());
        myPortfolio.showPortfolio();

    }

}
