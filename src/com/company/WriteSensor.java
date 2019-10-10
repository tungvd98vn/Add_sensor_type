package com.company;

public class WriteSensor extends  WriteFile{
    // all sensor classes should extend from class Sensor
    private String SensorName;
    private Object Object;

    /**
     *
     */
    public WriteSensor(String name)
    {
        super();
        this.SensorName = name;
    }
    /**
     *
     * @param ProjectName
     * @param path
     *
     */
    public WriteSensor(String name,String path)
    {
        super(name+".java", path);
        this.SensorName = name;
    }

    @Override
    public int CreateFile()
    {
        return super.CreateFile();
    }

    /**
     * Writes the C file.
     * @param Objects list of object to be added in the file.
     *
     */

    public void WriteFile(Object Object)
    {
        System.out.println("writing file");
        this.Object = Object;
        WriteClassDeclaration();
        WriteOpeningBracket();
        WriteLine("");
        WriteProperties();
        WriteMethods();
        WriteLine("");
        WriteClosingBracket();
    }

    public void WriteClassDeclaration(){
        this.Write("public class " + this.SensorName + " extends Sensor ");
    }

    public void WriteProperties(){
        for (int i =0; i < Object.getProperties().size(); i++){
            this.WriteLine(Object.getProperties().get(i));
        }
    }

    public void WriteMethods(){
        for (int i =0; i < Object.getMethods().size(); i++){
            this.WriteLine(Object.getMethods().get(i));
        }
    }
}
