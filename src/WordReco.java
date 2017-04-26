
import edu.columbia.ccls.madamira.MADAMIRAWrapper;
import edu.columbia.ccls.madamira.configuration.MadamiraInput;
import edu.columbia.ccls.madamira.configuration.MadamiraOutput;
import java.io.BufferedWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutionException;


/**
 *
 * @author amal
 */
public class WordReco {

    // MADAMIRA namespace as defined by its XML schema
    private static final String MADAMIRA_NS = "edu.columbia.ccls.madamira.configuration";
    private static final String INPUT_FILE = "InputFile.xml";
    private static final String OUTPUT_FILE = "output.xml";
    private static String text= "";
    
    
    public WordReco(String word) {
        // TODO code application logic here
        final MADAMIRAWrapper wrapper = new MADAMIRAWrapper();
        JAXBContext jc = null;
        //user input
        prepInputFile(word);
        
        try {
            

            PrintWriter writer = new PrintWriter(INPUT_FILE, "UTF-8");
            writer.println(text);
            writer.close();
    
    
            jc = JAXBContext.newInstance(MADAMIRA_NS);
            Unmarshaller unmarshaller = jc.createUnmarshaller();

            // The structure of the MadamiraInput object is exactly similar to the
            // madamira_input element in the XML
            final MadamiraInput input = (MadamiraInput)unmarshaller.unmarshal(
                    new File( INPUT_FILE ) );

            {
                int numSents = input.getInDoc().getInSeg().size();
                String outputAnalysis = input.getMadamiraConfiguration().
                        getOverallVars().getOutputAnalyses();
                String outputEncoding = input.getMadamiraConfiguration().
                        getOverallVars().getOutputEncoding();

                System.out.println("processing " + numSents +
                        " sentences for analysis type = " + outputAnalysis +
                        " and output encoding = " + outputEncoding);
            }

            // The structure of the MadamiraOutput object is exactly similar to the
            // madamira_output element in the XML
            final MadamiraOutput output = wrapper.processString(input);

            {
                int numSents = output.getOutDoc().getOutSeg().size();

                System.out.println("processed output contains "+numSents+" sentences...");
            }


            jc.createMarshaller().marshal(output, new File(OUTPUT_FILE));


        } catch (JAXBException ex) {
            System.out.println("Error marshalling or unmarshalling data: "
                    + ex.getMessage());
        } catch (InterruptedException ex) {
            System.out.println("MADAMIRA thread interrupted: "
                    +ex.getMessage());
        } catch (ExecutionException ex) {
            System.out.println("Unable to retrieve result of task. " +
                    "MADAMIRA task may have been aborted: "+ex.getCause());
        }
        catch (IOException ex) {
            System.out.println("Unable to retrieve result of task. " +
                    "MADAMIRA task may have been aborted: "+ex.getCause());
        }

        wrapper.shutdown();
    
    }
    
    public static void prepInputFile (String word) {
        text = "";
        text = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +

"<!-- ~ Copyright (c) 2013. The Trustees of Columbia University in the City of New York. ~ The copyright owner has no objection to the reproduction of this work by anyone for ~ non-commercial use, but otherwise reserves all rights whatsoever. For avoidance of ~ doubt, this work may not be reproduced, or modified, in whole or in part, for commercial ~ use without the prior written consent of the copyright owner. -->\n" +

"<madamira_input xmlns=\"urn:edu.columbia.ccls.madamira.configuration:0.1\">\n" +

"\n" +
"<madamira_configuration>\n" +

"<preprocessing input_encoding=\"UTF8\" separate_punct=\"true\" sentence_ids=\"false\"/>\n" +

"<overall_vars morph_backoff=\"NONE\" output_analyses=\"TOP\" dialect=\"MSA\" output_encoding=\"UTF8\"/>\n" +

"\n" +
"<requested_output>\n" +

"<req_variable value=\"true\" name=\"PREPROCESSED\"/>\n" +

"<req_variable value=\"true\" name=\"STEM\"/>\n" +

"<req_variable value=\"true\" name=\"GLOSS\"/>\n" +

"<req_variable value=\"true\" name=\"LEMMA\"/>\n" +

"<req_variable value=\"true\" name=\"DIAC\"/>\n" +

"<req_variable value=\"true\" name=\"ASP\"/>\n" +

"<req_variable value=\"true\" name=\"CAS\"/>\n" +

"<req_variable value=\"true\" name=\"ENC0\"/>\n" +

"<req_variable value=\"false\" name=\"ENC1\"/>\n" +

"<req_variable value=\"false\" name=\"ENC2\"/>\n" +

"<req_variable value=\"true\" name=\"GEN\"/>\n" +

"<req_variable value=\"true\" name=\"MOD\"/>\n" +

"<req_variable value=\"true\" name=\"NUM\"/>\n" +

"<req_variable value=\"true\" name=\"PER\"/>\n" +

"<req_variable value=\"true\" name=\"POS\"/>\n" +

"<req_variable value=\"true\" name=\"PRC0\"/>\n" +

"<req_variable value=\"true\" name=\"PRC1\"/>\n" +

"<req_variable value=\"true\" name=\"PRC2\"/>\n" +

"<req_variable value=\"true\" name=\"PRC3\"/>\n" +

"<req_variable value=\"true\" name=\"STT\"/>\n" +

"<req_variable value=\"true\" name=\"VOX\"/>\n" +

"<req_variable value=\"false\" name=\"BW\"/>\n" +

"<req_variable value=\"false\" name=\"SOURCE\"/>\n" +

"<req_variable value=\"true\" name=\"NER\"/>\n" +

"<req_variable value=\"true\" name=\"BPC\"/>\n" +

"</requested_output>\n" +

"\n" +
"<tokenization>\n" +

"<scheme alias=\"ATB\"/>\n" +

"<scheme alias=\"D3_BWPOS\"/>\n" +
"\n" +
"<!-- Required for NER -->\n" +

"\n" +
"<scheme alias=\"ATB4MT\"/>\n" +

"\n" +
"<scheme alias=\"MyD3\">\n" +

"<!-- Same as D3 -->\n" +

"\n" +
"\n" +
"<scheme_override alias=\"MyD3\" tokenize_from_BW=\"false\" token_delimiter=\" \" mark_no_analysis=\"false\" include_non_arabic=\"true\" form_delimiter=\"\\u00B7\">\n" +

"<split_term_spec term=\"PRC3\"/>\n" +

"<split_term_spec term=\"PRC2\"/>\n" +

"<split_term_spec term=\"PART\"/>\n" +

"<split_term_spec term=\"PRC0\"/>\n" +

"<split_term_spec term=\"REST\"/>\n" +

"<split_term_spec term=\"ENC0\"/>\n" +

"\n" +
"<token_form_spec transliteration=\"UTF8\" token_form_base=\"WORD\" proclitic_mark=\"+\" enclitic_mark=\"+\">\n" +

"<normalization type=\"ALEF\"/>\n" +

"<normalization type=\"YAA\"/>\n" +

"<normalization type=\"DIAC\"/>\n" +

"<normalization type=\"LEFTPAREN\"/>\n" +

"<normalization type=\"RIGHTPAREN\"/>\n" +

"</token_form_spec>\n" +

"</scheme_override>\n" +

"</scheme>\n" +

"</tokenization>\n" +

"</madamira_configuration>\n" +

"\n" +
"<in_doc id=\"ExampleDocument\">\n" +

"<in_seg id=\"SENT1\">" + word + "</in_seg>\n" +

"</in_doc>\n" +

"</madamira_input>";
    
    }
    
}
