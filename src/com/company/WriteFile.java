package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringBufferInputStream;
public class WriteFile {
    /**
     * Filename : Represents the file to write.
     *
     */
    private String filename;

    /**
     * Path : Path of the file.
     */
    private String path;

    /**
     * File : file pointer of file to write.
     */
    private File file;

    private StringBuffer TextAreaBuffer;

    public static final int ERROR_FILE_EXIST=2;
    public static final int SUCCESS_FILE_CREATE=1;
    public static final int ERROR_FILE_CREATE=0;

    public WriteFile() {
        TextAreaBuffer = new StringBuffer();
    }

    public WriteFile(String filename,String path)
    {
        this.filename = filename;
        this.path = path;
        file = new File(this.path+"/"+this.filename);
    }

    /**
     * Create the file for the file set during the constructor.
     *
     * @return
     *        SUCESS_FILE_CREATE if file created correctly.
     *        ERROR_FILE_EXIST if file already exist in the folder.
     *        ERROR_FILE_CREATE if file creation generates exception.
     */
    protected int CreateFile() {
        // not working yet. sth has to do with MANIFEST file
        // java.io.IOException: Permission denied
        try {
            if(file.exists())
                return ERROR_FILE_EXIST;
            file.createNewFile();

            System.out.println("createFile OK");
            return SUCCESS_FILE_CREATE;
        }
        catch(Exception e) {
            System.out.println("createFile NOT OK");
            System.out.println(e.toString());
            return ERROR_FILE_CREATE;
        }
    }

    /**
     * Writes a line in the file. At the end of string \n is written for moving into next line.
     *
     * @param str
     * @return 1 if write in the file complete successfully
     *         else return 0
     */
    protected int WriteLine(String str) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(file,true));

            writer.println(str);

            writer.close();

            return 1;
        }

        catch(Exception e)
        {
            System.out.println(e.toString());
            return 0;
        }
    }

    /**
     * Writes given string in the file.
     *
     * @param str string to be written in the file.
     * @return 1 if write in the file complete successfully
     *         else return 0
     */
    protected int Write(String str) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(file,true));

            writer.print(str);

            writer.close();

            return 1;
        }

        catch(Exception e)
        {
            System.out.println(e.toString());
            return 0;
        }
    }

    /**
     * write "{" in the file.
     * @return 1 if write in the file complete successfully
     *         else return 0
     */
    protected int WriteOpeningBrace() {
        return this.WriteLine("{");
    }

    /**
     * write "}" in the file.
     * @return 1 if write in the file complete successfully
     *         else return 0
     */
    protected int WriteClosingBrace() {
        return this.WriteLine("}");
    }

    /**
     * write "(" in the file.
     * @return 1 if write in the file complete successfully
     *         else return 0
     */
    protected int WriteOpeningBracket() {
        return this.Write("(");
    }

    /**
     * write ")" in the file.
     * @return 1 if write in the file complete successfully
     *         else return 0
     */
    protected int WriteClosingBracket() {
        return this.Write(")");
    }

    /**
     * write "<" in the file.
     * @return 1 if write in the file complete successfully
     *         else return 0
     */
    protected int WriteOpeningAngleBracket() {
        return this.Write("<");
    }

    /**
     * write ">" in the file.
     * @return 1 if write in the file complete successfully
     *         else return 0
     */
    protected int WriteClosingAngleBracket() {
        return this.Write(">");
    }

    /**
     * write ";" in the file. This is also followed by "\n" for moving into nextline.
     * @return 1 if write in the file complete successfully
     *         else return 0
     */
    protected int WriteSemicolon() {
        return this.WriteLine(";");
    }

    /**
     * write TAB in the file.
     * @return 1 if write in the file complete successfully
     *         else return 0
     */
    protected int WriteTab() {
        return this.Write("\t");
    }

    public StringBuffer GetTextAreaText() {
        return TextAreaBuffer;
    }
}
