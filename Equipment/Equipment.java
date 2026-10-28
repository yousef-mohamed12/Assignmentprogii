package Equipment;

public class Equipment {
    private String id, name, equipmentType;
    private boolean status;

    public Equipment(String id, String name, String equipmentType){
        if (name == null || name.trim().isEmpty() || equipmentType == null || equipmentType.trim().isEmpty()) 
            throw new IllegalArgumentException("Invalid name or equipment type for the equipment");
        this.id = id;
        this.name = name;
        this.equipmentType = equipmentType;
        this.status = true;
    }
    
    public void damage(){
        if(this.status == false){
            System.out.println("the equipment is already damaged");
            return;
        } 
        this.status = false;
    }
    public void repair(){
        if(this.status == true){
            System.out.println("the equipment is functional no need for repair");
            return;
        } 
        this.status = true;
    }


    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEquipmentType() {
        return this.equipmentType;
    }

    public boolean getStatus(){
        return this.status;
    }
}
