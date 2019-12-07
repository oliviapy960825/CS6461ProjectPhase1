package CPUAttributes;

import FrontPanel.UserInterface;

import java.util.ArrayList;
import java.util.List;

public class Program2 {
    private UserInterface userInterface;
    List list = new ArrayList<String>();

    public Program2() {

    }

    public void LoadSentences() {
        List<String> list = new ArrayList<String>();
        String Sentences = "Python is an easy to learn, powerful programming language. "
                + "It has efficient high-level data structures and a simple but effective approach to object-oriented programming. "
                + "Python’s elegant syntax and dynamic typing, together with its interpreted nature, make it an ideal language for scripting and rapid application development in many areas on most platforms. "
                + "Next, install the Python interpreter on your computer. "
                + "When you are ready to write your first program, you will need a text editor. "
                + "Or, if you prefer to learn Python through listening to a lecture, you can attend a training course or even hire a trainer to come to your company. ";
        for (String retval: Sentences.split("\\s+|,")) {
            list.add(retval);
        }
        userInterface.updateLogText(Sentences);
    }
}
