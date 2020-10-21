/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Main.java                                          :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/10/21 17:24:42 by svan-nie          #+#    #+#             */
/*   Updated: 2020/10/21 17:24:42 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package src;


import java.io.File;

public class Main{
    public static void main(String[] args){
        try {
            File newVideo = new File("Video");
            File newCompressed = new File("Compressed");
            File newImages = new File("Images");
            File newPrograms = new File("Programs");
            File newDocuments = new File("Documents");
            File newMusic = new File("Music");
            
            Boolean fileExist = newVideo.exists();
            if (!fileExist)
            newVideo.mkdir();
            fileExist = newCompressed.exists();
            if (!fileExist)
            newCompressed.mkdir();
            fileExist = newImages.exists();
            if (!fileExist)
            newImages.mkdir();
            fileExist = newPrograms.exists();
            if (!fileExist)
            newPrograms.mkdir();
            fileExist = newDocuments.exists();
            if (!fileExist)
            newDocuments.mkdir();
            fileExist = newMusic.exists();
            if (!fileExist)
            newMusic.mkdir();

            File absolutePath = new File("Video/..");
            int absoulutePathcount = absolutePath.list().length;
            String contentInsideDownloads[] = absolutePath.list();
            // System.out.println(absoulutePathcount);
            absoulutePathcount--;
            // System.out.println(contentInsideDownloads);
            while(absoulutePathcount >= 0){
                // System.out.println("Inside here: "+contentInsideDownloads[absoulutePathcount]);
                // System.out.println(contentInsideDownloads[absoulutePathcount]);
                String fileName = contentInsideDownloads[absoulutePathcount];
                String extendtionOfFile = null;
                int count = fileName.length();
                count--;
                int count2 = 0;
                int fileType = 0;
                while (count2 <= count){
                    char firstCharacter = fileName.charAt(count2);
                    char firstCharacter2 = '\0';
                    char secondCharacter = '\0';
                    char thirdCharacter = '\0';
                    if (firstCharacter == '.'){
                        count2++;
                        fileType = 0;
                        while (count2 <= count){
                            firstCharacter = fileName.charAt(count2);
                            if (fileType == 0 && ((firstCharacter == 'j') || (firstCharacter == 'p') || (firstCharacter == 'g') || 
                            (firstCharacter == 'e') || (firstCharacter == 'r') || (firstCharacter == 'z') || (firstCharacter == 'd') || 
                            (firstCharacter == 't') || (firstCharacter == 'p') || (firstCharacter == 'm') || (firstCharacter == 'a') || 
                            (firstCharacter == 'f') || (firstCharacter == 'w'))){
                                fileType++;
                                firstCharacter2 = firstCharacter;
                            }else if (fileType == 1 && ((firstCharacter == 'p') || (firstCharacter == 'n') || (firstCharacter == 'i') || (firstCharacter == 'x') || 
                            (firstCharacter == 'a') || (firstCharacter == 'e') || (firstCharacter == 'o') || (firstCharacter == 'd') || (firstCharacter == 'v') || 
                            (firstCharacter == 'l') || (firstCharacter == 'm') || (firstCharacter == 'k') || (firstCharacter == 'w'))){
                                fileType++;
                                secondCharacter = firstCharacter;
                            }else if (fileType == 2 && count2 == count && ((firstCharacter == 'g') || (firstCharacter == 'f') || (firstCharacter == 'e') || (firstCharacter == 'r') || 
                            (firstCharacter == 'p') || (firstCharacter == 'c') || (firstCharacter == 't') || (firstCharacter == '3') || (firstCharacter == '4') || (firstCharacter == 'i') || 
                            (firstCharacter == 'v'))){
                                fileType++;
                                thirdCharacter = firstCharacter;
                            }
                            count2++;
                        }
                    }
                    count2++;
                    if (fileType == 3){
                        // System.out.println(firstCharacter2);
                        // System.out.println(secondCharacter);
                        // System.out.println(thirdCharacter);
                        if (firstCharacter2 == 'j' && secondCharacter == 'p' && thirdCharacter == 'g'){
                            // System.out.println("Found image");
                            moveFileToImages(contentInsideDownloads, absoulutePathcount);
                        }else if (firstCharacter2 == 'p' && secondCharacter == 'n' && thirdCharacter == 'g'){
                            moveFileToImages(contentInsideDownloads, absoulutePathcount);
                        }else if (firstCharacter2 == 'g' && secondCharacter == 'i' && thirdCharacter == 'f'){
                            moveFileToImages(contentInsideDownloads, absoulutePathcount);
                        }else if (firstCharacter2 == 'e' && secondCharacter == 'x' && thirdCharacter == 'e'){
                            moveFileToPrograms(contentInsideDownloads, absoulutePathcount);
                        }else if (firstCharacter2 == 'r' && secondCharacter == 'a' && thirdCharacter == 'r'){
                            moveFileToCompressed(contentInsideDownloads, absoulutePathcount);
                        }else if (firstCharacter2 == 'z' && secondCharacter == 'i' && thirdCharacter == 'p'){
                            moveFileToCompressed(contentInsideDownloads, absoulutePathcount);
                        }else if (firstCharacter2 == 'd' && secondCharacter == 'o' && thirdCharacter == 'c'){
                            moveFileToDocuments(contentInsideDownloads, absoulutePathcount);
                        }else if (firstCharacter2 == 't' && secondCharacter == 'x' && thirdCharacter == 't'){
                            moveFileToDocuments(contentInsideDownloads, absoulutePathcount);
                        }else if (firstCharacter2 == 'p' && secondCharacter == 'd' && thirdCharacter == 'f'){
                            moveFileToDocuments(contentInsideDownloads, absoulutePathcount);
                        }else if (firstCharacter2 == 'm' && secondCharacter == 'p' && thirdCharacter == '3'){
                            moveFileToMusic(contentInsideDownloads, absoulutePathcount);
                        }else if (firstCharacter2 == 'm' && secondCharacter == 'p' && thirdCharacter == '4'){
                            moveFileToVideo(contentInsideDownloads, absoulutePathcount);
                        }else if (firstCharacter2 == 'm' && secondCharacter == 'k' && thirdCharacter == 'v'){
                            moveFileToVideo(contentInsideDownloads, absoulutePathcount);
                        }else if (firstCharacter2 == 'm' && secondCharacter == 'o' && thirdCharacter == 'v'){
                            moveFileToVideo(contentInsideDownloads, absoulutePathcount);
                        }else if (firstCharacter2 == 'm' && secondCharacter == 'w' && thirdCharacter == 'v'){
                            moveFileToVideo(contentInsideDownloads, absoulutePathcount);
                        }else if (firstCharacter2 == 'f' && secondCharacter == 'l' && thirdCharacter == 'v'){
                            moveFileToVideo(contentInsideDownloads, absoulutePathcount);
                        }else if (firstCharacter2 == 'a' && secondCharacter == 'v' && thirdCharacter == 'i'){
                            moveFileToVideo(contentInsideDownloads, absoulutePathcount);
                        }
                    }
                }
                absoulutePathcount--;
            }
        } catch (Exception e) {
            System.out.println("ERROR: ");
            //TODO: handle exception
        }
    }

    private static void moveFileToImages(String[] contentInsideDownloads, int absoulutePathcount){
            File file = new File(contentInsideDownloads[absoulutePathcount]); 
          
            // renaming the file and moving it to a new location 
            if(file.renameTo 
               (new File("Images/"+contentInsideDownloads[absoulutePathcount]))) 
            { 
                // if file copied successfully then delete the original file 
                file.delete(); 
                System.out.println("File moved successfully"); 
            } 
            else
            { 
                System.out.println("Failed to move the file"); 
            }
    }

    private static void moveFileToPrograms(String[] contentInsideDownloads, int absoulutePathcount){
        File file = new File(contentInsideDownloads[absoulutePathcount]); 
      
        // renaming the file and moving it to a new location 
        if(file.renameTo 
           (new File("Programs/"+contentInsideDownloads[absoulutePathcount]))) 
        { 
            // if file copied successfully then delete the original file 
            file.delete(); 
            System.out.println("File moved successfully"); 
        } 
        else
        { 
            System.out.println("Failed to move the file"); 
        }
}

private static void moveFileToCompressed(String[] contentInsideDownloads, int absoulutePathcount){
    File file = new File(contentInsideDownloads[absoulutePathcount]); 
  
    // renaming the file and moving it to a new location 
    if(file.renameTo 
       (new File("Compressed/"+contentInsideDownloads[absoulutePathcount]))) 
    { 
        // if file copied successfully then delete the original file 
        file.delete(); 
        System.out.println("File moved successfully"); 
    } 
    else
    { 
        System.out.println("Failed to move the file"); 
    }
}

private static void moveFileToDocuments(String[] contentInsideDownloads, int absoulutePathcount){
    File file = new File(contentInsideDownloads[absoulutePathcount]); 
  
    // renaming the file and moving it to a new location 
    if(file.renameTo 
       (new File("Documents/"+contentInsideDownloads[absoulutePathcount]))) 
    { 
        // if file copied successfully then delete the original file 
        file.delete(); 
        System.out.println("File moved successfully"); 
    } 
    else
    { 
        System.out.println("Failed to move the file"); 
    }
}

private static void moveFileToMusic(String[] contentInsideDownloads, int absoulutePathcount){
    File file = new File(contentInsideDownloads[absoulutePathcount]); 
  
    // renaming the file and moving it to a new location 
    if(file.renameTo 
       (new File("Music/"+contentInsideDownloads[absoulutePathcount]))) 
    { 
        // if file copied successfully then delete the original file 
        file.delete(); 
        System.out.println("File moved successfully"); 
    } 
    else
    { 
        System.out.println("Failed to move the file"); 
    }
}

private static void moveFileToVideo(String[] contentInsideDownloads, int absoulutePathcount){
    File file = new File(contentInsideDownloads[absoulutePathcount]); 
  
    // renaming the file and moving it to a new location 
    if(file.renameTo 
       (new File("Video/"+contentInsideDownloads[absoulutePathcount]))) 
    { 
        // if file copied successfully then delete the original file 
        file.delete(); 
        System.out.println("File moved successfully"); 
    } 
    else
    { 
        System.out.println("Failed to move the file"); 
    }
}
}