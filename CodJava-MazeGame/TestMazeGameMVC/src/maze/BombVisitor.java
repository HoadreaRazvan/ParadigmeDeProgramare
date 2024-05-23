package maze;

public class BombVisitor implements Visitor {


    @Override
    public void visit(Room room) {
        if (room.containsBomb()) {
            System.out.println("Boom! Ai explodat o bomba! Jocul s-a terminat.");

            System.exit(0);
        } else {
            System.out.println("Ai intrat intr-o camera fara bomba.");
        }
    }
}

