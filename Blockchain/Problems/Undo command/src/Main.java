interface Movable {
    int getX();

    int getY();

    void setX(int newX);

    void setY(int newY);
}

interface Storable {
    int getInventoryLength();

    String getInventoryItem(int index);

    void setInventoryItem(int index, String item);
}

interface Command {
    void execute();

    void undo();
}

class CommandMove implements Command {
    Movable entity;
    int xMovement;
    int yMovement;

    public CommandMove() {
    }

    public CommandMove(Movable entity, int xMovement, int yMovement) {
        this.entity = entity;
        this.xMovement = xMovement;
        this.yMovement = yMovement;
    }

    @Override
    public void execute() {
        entity.setX(entity.getX() + xMovement);
        entity.setY(entity.getY() + yMovement);
    }

    @Override
    public void undo() {
        entity.setX(entity.getX() - xMovement);
        entity.setY(entity.getY() - yMovement);
    }
}

class CommandPutItem implements Command {
    Storable entity;
    String item;
    int idx;

    public CommandPutItem() {
    }

    public CommandPutItem(Storable entity, String item) {
        this.entity = entity;
        this.item = item;
    }

    @Override
    public void execute() {
        for (int i = 0; i < entity.getInventoryLength(); i++) {
            if (entity.getInventoryItem(i) == null) {
                entity.setInventoryItem(i, item);
                idx = i;
                break;
            }
        }
    }

    @Override
    public void undo() {
        /*for (int i = entity.getInventoryLength() - 1; i > 0; i--) {
            if (entity.getInventoryItem(i) == item) {
                entity.setInventoryItem(i, null);
                break;
            }
        }*/
        entity.setInventoryItem(idx, null);
    }
}