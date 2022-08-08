package MyIslandModel;

import java.util.HashMap;

import MyIslandModel.IslandReferences.AnimalClasses;
import MyIslandModel.IslandModel.*;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class IslandModelStart {

    public static void main(String[] args) throws Exception {
        //вводные данные из файла xml
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("C://IdeaProjects/islandFile.xml"));

        NodeList width = document.getDocumentElement().getElementsByTagName("width").item(0).getChildNodes();
        int islandWidth = Integer.parseInt(width.item(0).getNodeValue());

        NodeList height = document.getDocumentElement().getElementsByTagName("height").item(0).getChildNodes();
        int islandHeight = Integer.parseInt(height.item(0).getNodeValue());

        HashMap<Class, Integer> appearedAnimals = new HashMap<>();

        NodeList myIslandAnimals = document.getDocumentElement().getElementsByTagName("animal");
        for (int i = 0; i < myIslandAnimals.getLength(); i++) {
            Node myIslandAnimal = myIslandAnimals.item(i);
            NamedNodeMap attributes = myIslandAnimal.getAttributes();

            int numberOfAnimal = Integer.parseInt(attributes.getNamedItem("count").getNodeValue());

            if (numberOfAnimal > 0) {
                appearedAnimals.put(AnimalClasses.getAnimalClassesForXmlfile().get(attributes.getNamedItem("class").getNodeValue()),
                        Integer.parseInt(attributes.getNamedItem("count").getNodeValue()));
            }
        }

        IslandModel.islandCreate(islandWidth, islandHeight, appearedAnimals);

        IslandLife.islandLifeRun();


    }
}
