import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String input = "yr|subject|winner\n" +
                "1927|Literature|Henri Bergson\n" +
                "1976|Economics|Milton Friedman\n" +
                "1971|Physics|Dennis Gabor\n" +
                "1985|Chemistry|Herbert A. Hauptman\n" +
                "2006|Chemistry|Roger D. Kornberg\n" +
                "1979|Medicine|Godfrey N. Hounsfield\n" +
                "2012|Literature|Mo Yan\n" +
                "1902|Peace|Ã‰lie Ducommun\n" +
                "1922|Peace|Fridtjof Nansen\n" +
                "1907|Literature|Rudyard Kipling\n" +
                "1911|Physics|Wilhelm Wien\n" +
                "2000|Chemistry|Alan G. MacDiarmid\n" +
                "2001|Medicine|Tim Hunt\n" +
                "1997|Peace|International Campaign to Ban Landmines\n" +
                "1905|Literature|Henryk Sienkiewicz\n" +
                "1985|Economics|Franco Modigliani\n" +
                "1976|Medicine|D. Carleton Gajdusek\n" +
                "1944|Peace|International Committee of the Red Cross\n" +
                "1956|Chemistry|Sir Cyril Hinshelwood\n" +
                "1966|Physics|Alfred Kastler\n" +
                "2015|Physics|Arthur B. McDonald\n" +
                "1963|Literature|Giorgos Seferis\n" +
                "2002|Chemistry|Kurt WÃ¼thrich\n" +
                "1999|Literature|GÃ¼nter Grass\n" +
                "1978|Literature|Isaac Bashevis Singer\n" +
                "1987|Chemistry|Donald J. Cram\n" +
                "1996|Economics|William Vickrey\n" +
                "2011|Physics|Brian Schmidt\n" +
                "1904|Literature|FrÃ©dÃ©ric Mistral\n" +
                "2006|Medicine|Andrew Z. Fire\n" +
                "1992|Economics|Gary S. Becker\n" +
                "1949|Medicine|Walter Hess\n" +
                "1957|Literature|Albert Camus\n" +
                "2002|Economics|Vernon L. Smith\n" +
                "1946|Medicine|Hermann J. Muller\n" +
                "1930|Physics|Sir Venkata Raman\n" +
                "1906|Medicine|Camillo Golgi\n" +
                "1913|Peace|Henri La Fontaine\n" +
                "2007|Medicine|Oliver Smithies\n" +
                "2004|Physics|David J. Gross\n" +
                "1950|Physics|Cecil Powell\n" +
                "1922|Chemistry|Francis W. Aston\n" +
                "1901|Literature|Sully Prudhomme\n" +
                "1967|Physics|Hans Bethe\n" +
                "1926|Chemistry|The Svedberg\n" +
                "1975|Peace|Andrei Sakharov\n" +
                "1976|Literature|Saul Bellow\n" +
                "2002|Chemistry|John B. Fenn\n" +
                "2000|Economics|James J. Heckman\n" +
                "2007|Economics|Leonid Hurwicz\n" +
                "1983|Physics|William A. Fowler\n" +
                "2008|Chemistry|Osamu Shimomura\n" +
                "2010|Chemistry|Richard F. Heck\n" +
                "1997|Chemistry|Paul D. Boyer\n" +
                "1981|Literature|Elias Canetti\n" +
                "1906|Peace|Theodore Roosevelt\n" +
                "1958|Chemistry|Frederick Sanger\n" +
                "1997|Economics|Robert C. Merton\n" +
                "1927|Physics|Arthur H. Compton\n" +
                "1909|Peace|Paul Henri d'Estournelles de Constant\n" +
                "2008|Medicine|Harald zur Hausen\n" +
                "1936|Chemistry|Peter Debye\n" +
                "1974|Literature|Eyvind Johnson\n" +
                "1968|Peace|RenÃ© Cassin\n" +
                "1969|Economics|Ragnar Frisch\n" +
                "1965|Medicine|AndrÃ© Lwoff\n" +
                "1903|Peace|Randal Cremer\n" +
                "1911|Medicine|Allvar Gullstrand\n" +
                "1964|Physics|Charles H. Townes\n" +
                "2010|Literature|Mario Vargas Llosa\n" +
                "1963|Physics|Maria Goeppert-Mayer\n" +
                "1982|Chemistry|Aaron Klug\n" +
                "1974|Economics|Friedrich August von Hayek\n" +
                "2001|Chemistry|Ryoji Noyori\n" +
                "1943|Medicine|Henrik Dam\n" +
                "1966|Medicine|Peyton Rous\n" +
                "2006|Peace|Grameen Bank\n" +
                "1985|Physics|Klaus von Klitzing\n" +
                "1977|Physics|John H. van Vleck\n" +
                "1969|Chemistry|Derek Barton\n" +
                "2004|Medicine|Linda B. Buck\n" +
                "1929|Physics|Louis de Broglie\n" +
                "1994|Literature|Kenzaburo Oe\n" +
                "1972|Physics|Leon N. Cooper\n" +
                "2001|Medicine|Leland H. Hartwell\n" +
                "1974|Literature|Harry Martinson\n" +
                "1910|Literature|Paul Heyse\n" +
                "1961|Medicine|Georg von BÃ©kÃ©sy\n" +
                "1959|Peace|Philip Noel-Baker\n" +
                "1986|Medicine|Rita Levi-Montalcini\n" +
                "1980|Medicine|Baruj Benacerraf\n" +
                "1912|Physics|Gustaf DalÃ©n\n" +
                "2007|Literature|Doris Lessing\n" +
                "1960|Medicine|Peter Medawar\n" +
                "1956|Physics|Walter H. Brattain\n" +
                "1959|Literature|Salvatore Quasimodo\n" +
                "1959|Chemistry|Jaroslav Heyrovsky\n" +
                "1974|Economics|Gunnar Myrdal\n" +
                "1977|Medicine|Roger Guillemin\n" +
                "1956|Physics|John Bardeen\n" +
                "2010|Chemistry|Ei-ichi Negishi\n" +
                "1944|Literature|Johannes V. Jensen\n" +
                "1974|Medicine|Christian de Duve\n" +
                "1909|Medicine|Theodor Kocher\n" +
                "1988|Medicine|Sir James W. Black\n" +
                "1999|Physics|Martinus J.G. Veltman\n" +
                "1971|Chemistry|Gerhard Herzberg\n" +
                "1979|Chemistry|Herbert C. Brown\n" +
                "1951|Literature|PÃ¤r Lagerkvist\n" +
                "2003|Literature|J. M. Coetzee\n" +
                "1944|Chemistry|Otto Hahn\n" +
                "1930|Literature|Sinclair Lewis\n" +
                "1960|Chemistry|Willard F. Libby\n" +
                "1962|Chemistry|John C. Kendrew\n" +
                "1977|Economics|Bertil Ohlin\n" +
                "1948|Literature|T.S. Eliot\n" +
                "1909|Physics|Guglielmo Marconi\n" +
                "2012|Medicine|Shinya Yamanaka\n" +
                "1920|Literature|Knut Hamsun\n" +
                "1917|Physics|Charles Glover Barkla\n" +
                "1966|Medicine|Charles B. Huggins\n" +
                "1930|Chemistry|Hans Fischer\n" +
                "1955|Physics|Willis E. Lamb\n" +
                "1993|Economics|Robert W. Fogel\n" +
                "1988|Physics|Jack Steinberger\n" +
                "1970|Medicine|Julius Axelrod\n" +
                "1947|Physics|Edward V. Appleton\n" +
                "1977|Chemistry|Ilya Prigogine\n" +
                "2001|Chemistry|William S. Knowles\n" +
                "1981|Physics|Arthur L. Schawlow\n" +
                "1982|Peace|Alva Myrdal\n" +
                "1989|Literature|Camilo JosÃ© Cela\n" +
                "1979|Economics|Sir Arthur Lewis\n" +
                "1991|Literature|Nadine Gordimer\n" +
                "1907|Peace|Ernesto Teodoro Moneta\n" +
                "2001|Literature|V. S. Naipaul\n" +
                "2002|Medicine|John E. Sulston\n" +
                "2006|Physics|George F. Smoot\n" +
                "1975|Medicine|Renato Dulbecco\n" +
                "1981|Physics|Kai M. Siegbahn\n" +
                "1937|Chemistry|Norman Haworth\n" +
                "1927|Medicine|Julius Wagner-Jauregg\n" +
                "1924|Physics|Manne Siegbahn\n" +
                "1932|Literature|John Galsworthy\n" +
                "1967|Literature|Miguel Angel Asturias\n" +
                "2003|Peace|Shirin Ebadi\n" +
                "1912|Chemistry|Victor Grignard\n" +
                "1962|Medicine|Francis Crick\n" +
                "1902|Physics|Hendrik A. Lorentz\n" +
                "1901|Chemistry|Jacobus H. van 't Hoff\n" +
                "1932|Medicine|Sir Charles Sherrington\n" +
                "1971|Economics|Simon Kuznets\n" +
                "2010|Chemistry|Akira Suzuki\n" +
                "1951|Physics|John Cockcroft\n" +
                "1968|Medicine|Marshall W. Nirenberg\n" +
                "2009|Physics|George E. Smith\n" +
                "2007|Economics|Eric S. Maskin\n" +
                "1962|Peace|Linus Pauling\n" +
                "2003|Chemistry|Roderick MacKinnon\n" +
                "1973|Chemistry|Geoffrey Wilkinson\n" +
                "1912|Medicine|Alexis Carrel\n" +
                "1996|Economics|James A. Mirrlees\n" +
                "1937|Chemistry|Paul Karrer\n" +
                "1947|Literature|AndrÃ© Gide\n" +
                "1936|Physics|Victor F. Hess\n" +
                "1931|Peace|Nicholas Murray Butler\n" +
                "2011|Medicine|Bruce Beutler\n" +
                "1975|Chemistry|John Cornforth\n" +
                "1963|Chemistry|Giulio Natta\n" +
                "2004|Literature|Elfriede Jelinek\n" +
                "1939|Medicine|Gerhard Domagk\n" +
                "1976|Physics|Burton Richter\n" +
                "1939|Chemistry|Adolf Butenandt\n" +
                "1984|Chemistry|Bruce Merrifield\n" +
                "1919|Medicine|Jules Bordet\n" +
                "2013|Physics|Peter W. Higgs\n" +
                "1956|Physics|William B. Shockley\n" +
                "1924|Literature|Wladyslaw Reymont\n" +
                "1987|Physics|J. Georg Bednorz\n" +
                "1907|Chemistry|Eduard Buchner\n" +
                "1945|Chemistry|Artturi Virtanen\n" +
                "2008|Chemistry|Roger Y. Tsien\n" +
                "1957|Peace|Lester Bowles Pearson\n" +
                "2011|Economics|Christopher A. Sims\n" +
                "1985|Chemistry|Jerome Karle\n" +
                "1978|Chemistry|Peter Mitchell\n" +
                "1939|Literature|Frans Eemil SillanpÃ¤Ã¤\n" +
                "1959|Medicine|Arthur Kornberg\n" +
                "1992|Medicine|Edmond H. Fischer\n" +
                "1919|Physics|Johannes Stark\n" +
                "1947|Chemistry|Sir Robert Robinson\n" +
                "2000|Chemistry|Hideki Shirakawa\n" +
                "1944|Medicine|Joseph Erlanger\n" +
                "1988|Physics|Melvin Schwartz\n" +
                "2002|Physics|Masatoshi Koshiba\n" +
                "2010|Medicine|Robert G. Edwards\n" +
                "1973|Peace|Henry Kissinger\n" +
                "1985|Medicine|Michael S. Brown\n" +
                "2002|Economics|Daniel Kahneman\n" +
                "1930|Medicine|Karl Landsteiner\n" +
                "2011|Peace|Ellen Johnson Sirleaf\n" +
                "1982|Economics|George J. Stigler\n" +
                "1965|Literature|Mikhail Sholokhov\n" +
                "1917|Peace|International Committee of the Red Cross\n" +
                "1910|Chemistry|Otto Wallach\n" +
                "2001|Economics|Joseph E. Stiglitz\n" +
                "1954|Medicine|John F. Enders\n" +
                "1994|Physics|Bertram N. Brockhouse\n" +
                "1982|Medicine|Bengt I. Samuelsson\n" +
                "2005|Peace|Mohamed ElBaradei\n" +
                "1951|Medicine|Max Theiler\n" +
                "1958|Medicine|Joshua Lederberg\n" +
                "2009|Chemistry|Venkatraman Ramakrishnan\n" +
                "2013|Economics|Robert J. Shiller\n" +
                "1957|Physics|Tsung-Dao Lee\n" +
                "1976|Medicine|Baruch S. Blumberg\n" +
                "1929|Peace|Frank B. Kellogg\n" +
                "1911|Peace|Tobias Asser\n" +
                "1921|Peace|Hjalmar Branting\n" +
                "2014|Medicine|Edvard Moser\n" +
                "1950|Medicine|Edward C. Kendall\n" +
                "1935|Peace|Carl von Ossietzky\n" +
                "1996|Chemistry|Robert F. Curl Jr.\n" +
                "2014|Medicine|John O'Keefe\n" +
                "2005|Medicine|Barry J. Marshall\n" +
                "1999|Physics|Gerardus 't Hooft\n" +
                "2000|Medicine|Paul Greengard\n" +
                "1950|Medicine|Philip S. Hench\n" +
                "1998|Economics|Amartya Sen\n" +
                "1959|Physics|Owen Chamberlain\n" +
                "1995|Peace|Pugwash Conferences on Science and World Affairs\n" +
                "2011|Physics|Saul Perlmutter\n" +
                "1979|Medicine|Allan M. Cormack\n" +
                "1933|Peace|Sir Norman Angell\n" +
                "1906|Literature|GiosuÃ¨ Carducci\n" +
                "1980|Chemistry|Frederick Sanger\n" +
                "1905|Peace|Bertha von Suttner\n" +
                "1923|Literature|William Butler Yeats\n" +
                "1988|Chemistry|Johann Deisenhofer\n" +
                "2013|Medicine|James E. Rothman\n" +
                "1912|Chemistry|Paul Sabatier\n" +
                "1947|Medicine|Carl Cori\n" +
                "1960|Medicine|Sir Frank Macfarlane Burnet\n" +
                "1989|Medicine|Harold E. Varmus\n" +
                "1980|Chemistry|Walter Gilbert\n" +
                "1948|Chemistry|Arne Tiselius\n" +
                "1979|Peace|Mother Teresa\n" +
                "1980|Peace|Adolfo PÃ©rez Esquivel\n" +
                "1967|Medicine|Ragnar Granit\n" +
                "1997|Physics|Steven Chu\n" +
                "1957|Medicine|Daniel Bovet\n" +
                "1984|Medicine|Georges J.F. KÃ¶hler\n" +
                "1977|Peace|Amnesty International\n" +
                "1977|Physics|Sir Nevill F. Mott\n" +
                "2011|Peace|Tawakel Karman\n" +
                "1908|Chemistry|Ernest Rutherford\n" +
                "2005|Medicine|J. Robin Warren\n" +
                "1968|Medicine|H. Gobind Khorana\n" +
                "1956|Medicine|AndrÃ© F. Cournand\n" +
                "1970|Economics|Paul A. Samuelson\n" +
                "1993|Physics|Joseph H. Taylor Jr.\n" +
                "2015|Physics|Takaaki Kajita\n" +
                "1983|Medicine|Barbara McClintock\n" +
                "1950|Chemistry|Kurt Alder\n" +
                "1990|Economics|Harry M. Markowitz\n" +
                "1952|Chemistry|Archer J.P. Martin\n" +
                "1974|Physics|Antony Hewish\n" +
                "1974|Medicine|Albert Claude\n" +
                "1909|Peace|Auguste Beernaert\n" +
                "1902|Chemistry|Emil Fischer\n" +
                "1915|Physics|Lawrence Bragg\n" +
                "1989|Physics|Norman F. Ramsey\n" +
                "1995|Literature|Seamus Heaney\n" +
                "1979|Physics|Sheldon Glashow\n" +
                "1954|Medicine|Thomas H. Weller\n" +
                "1994|Peace|Shimon Peres\n" +
                "1995|Physics|Martin L. Perl\n" +
                "2005|Chemistry|Richard R. Schrock\n" +
                "1964|Physics|Nicolay G. Basov\n" +
                "1935|Physics|James Chadwick\n" +
                "1925|Literature|George Bernard Shaw\n" +
                "1967|Medicine|George Wald\n" +
                "1995|Economics|Robert E. Lucas Jr.\n" +
                "1978|Peace|Menachem Begin\n" +
                "2014|Chemistry|Eric Betzig\n" +
                "2015|Medicine|Tu Youyou\n" +
                "1993|Medicine|Phillip A. Sharp\n" +
                "1979|Chemistry|Georg Wittig\n" +
                "1905|Physics|Philipp Lenard\n" +
                "1926|Medicine|Johannes Fibiger\n" +
                "1957|Chemistry|Lord Todd\n" +
                "2011|Literature|Tomas TranstrÃ¶mer\n" +
                "1982|Peace|Alfonso GarcÃ\u00ADa Robles\n" +
                "1935|Chemistry|IrÃ¨ne Joliot-Curie\n" +
                "1939|Physics|Ernest Lawrence\n" +
                "1999|Chemistry|Ahmed Zewail\n" +
                "1918|Physics|Max Planck\n" +
                "1970|Medicine|Ulf von Euler\n" +
                "1996|Physics|David M. Lee\n" +
                "2005|Chemistry|Robert H. Grubbs\n" +
                "1963|Peace|International Committee of the Red Cross\n" +
                "1991|Economics|Ronald H. Coase\n" +
                "1936|Physics|Carl D. Anderson\n" +
                "1965|Peace|United Nations Children's Fund\n" +
                "2015|Literature|Svetlana Alexievich\n" +
                "2002|Physics|Riccardo Giacconi\n" +
                "1994|Chemistry|George A. Olah\n" +
                "1988|Physics|Leon M. Lederman\n" +
                "2005|Literature|Harold Pinter\n" +
                "1981|Medicine|Roger W. Sperry\n" +
                "2005|Physics|Roy J. Glauber\n" +
                "1956|Medicine|Werner Forssmann\n" +
                "1966|Chemistry|Robert S. Mulliken\n" +
                "2013|Physics|FranÃ§ois Englert\n" +
                "1975|Literature|Eugenio Montale\n" +
                "1902|Literature|Theodor Mommsen\n" +
                "2004|Medicine|Richard Axel\n" +
                "2009|Medicine|Jack W. Szostak\n" +
                "1974|Physics|Martin Ryle\n" +
                "1908|Physics|Gabriel Lippmann\n" +
                "1975|Economics|Tjalling C. Koopmans\n" +
                "1998|Literature|JosÃ© Saramago\n" +
                "1969|Economics|Jan Tinbergen\n" +
                "1956|Literature|Juan RamÃ³n JimÃ©nez\n" +
                "1943|Chemistry|George de Hevesy\n" +
                "1993|Literature|Toni Morrison\n" +
                "2006|Physics|John C. Mather\n" +
                "1965|Physics|Julian Schwinger\n" +
                "2007|Medicine|Mario R. Capecchi\n" +
                "1980|Chemistry|Paul Berg\n" +
                "1925|Physics|Gustav Hertz\n" +
                "1992|Physics|Georges Charpak\n" +
                "1970|Medicine|Sir Bernard Katz\n" +
                "1931|Literature|Erik Axel Karlfeldt\n" +
                "2001|Physics|Carl E. Wieman\n" +
                "1993|Economics|Douglass C. North\n" +
                "2004|Chemistry|Avram Hershko\n" +
                "1976|Physics|Samuel C.C. Ting\n" +
                "1961|Chemistry|Melvin Calvin\n" +
                "1980|Medicine|Jean Dausset\n" +
                "1965|Physics|Sin-Itiro Tomonaga\n" +
                "1929|Medicine|Sir Frederick Hopkins\n" +
                "2008|Chemistry|Martin Chalfie\n" +
                "1978|Medicine|Hamilton O. Smith\n" +
                "1928|Physics|Owen Willans Richardson\n" +
                "1988|Chemistry|Hartmut Michel\n" +
                "1919|Peace|Woodrow Wilson\n" +
                "2007|Chemistry|Gerhard Ertl\n" +
                "1932|Chemistry|Irving Langmuir\n" +
                "1964|Peace|Martin Luther King Jr.\n" +
                "1994|Economics|John F. Nash Jr.\n" +
                "1910|Physics|Johannes Diderik van der Waals\n" +
                "1901|Physics|Wilhelm Conrad RÃ¶ntgen\n" +
                "2009|Medicine|Elizabeth Blackburn\n" +
                "2000|Physics|Zhores I. Alferov\n" +
                "1962|Physics|Lev Landau\n" +
                "1911|Literature|Maurice Maeterlinck\n" +
                "1954|Literature|Ernest Hemingway\n" +
                "2008|Peace|Martti Ahtisaari\n" +
                "1934|Medicine|William P. Murphy\n" +
                "1976|Peace|Mairead Corrigan\n" +
                "1943|Medicine|Edward A. Doisy\n" +
                "1921|Chemistry|Frederick Soddy\n" +
                "1926|Peace|Gustav Stresemann\n" +
                "1973|Economics|Wassily Leontief\n" +
                "1974|Peace|SeÃ¡n MacBride\n" +
                "2004|Economics|Finn E. Kydland\n" +
                "1971|Peace|Willy Brandt\n" +
                "1973|Physics|Ivar Giaever\n" +
                "1952|Literature|FranÃ§ois Mauriac\n" +
                "1989|Physics|Wolfgang Paul\n" +
                "1972|Chemistry|Christian Anfinsen\n" +
                "1964|Physics|Aleksandr M. Prokhorov\n" +
                "1973|Literature|Patrick White\n" +
                "1928|Medicine|Charles Nicolle\n" +
                "1998|Physics|Robert B. Laughlin\n" +
                "2009|Literature|Herta MÃ¼ller\n" +
                "1983|Physics|Subramanyan Chandrasekhar\n" +
                "1990|Physics|Jerome I. Friedman\n" +
                "2012|Chemistry|Robert J. Lefkowitz\n" +
                "1997|Medicine|Stanley B. Prusiner\n" +
                "1995|Chemistry|F. Sherwood Rowland\n" +
                "1904|Physics|Lord Rayleigh\n" +
                "2001|Physics|Eric A. Cornell\n" +
                "1903|Literature|BjÃ¸rnstjerne BjÃ¸rnson\n" +
                "1998|Physics|Horst L. StÃ¶rmer\n" +
                "1936|Literature|Eugene O'Neill\n" +
                "1901|Peace|Henry Dunant\n" +
                "2008|Physics|Toshihide Maskawa\n" +
                "1977|Physics|Philip W. Anderson\n" +
                "2011|Chemistry|Dan Shechtman\n" +
                "1958|Literature|Boris Pasternak\n" +
                "2007|Medicine|Sir Martin J. Evans\n" +
                "2003|Chemistry|Peter Agre\n" +
                "1988|Chemistry|Robert Huber\n" +
                "1937|Literature|Roger Martin du Gard\n" +
                "1972|Chemistry|Stanford Moore\n" +
                "1907|Medicine|Alphonse Laveran\n" +
                "1950|Medicine|Tadeus Reichstein\n" +
                "1906|Medicine|Santiago RamÃ³n y Cajal\n" +
                "1952|Physics|E. M. Purcell\n" +
                "1979|Physics|Steven Weinberg\n" +
                "1923|Medicine|John Macleod\n" +
                "1923|Medicine|Frederick G. Banting\n" +
                "1913|Chemistry|Alfred Werner\n" +
                "1993|Chemistry|Michael Smith\n" +
                "2015|Chemistry|Aziz Sancar\n" +
                "2011|Medicine|Ralph M. Steinman\n" +
                "1952|Chemistry|Richard L.M. Synge\n" +
                "1954|Physics|Walther Bothe\n" +
                "1934|Medicine|George R. Minot\n" +
                "1997|Chemistry|John E. Walker\n" +
                "1949|Peace|Lord Boyd Orr\n" +
                "1984|Medicine|CÃ©sar Milstein\n" +
                "1985|Literature|Claude Simon\n" +
                "1968|Literature|Yasunari Kawabata\n" +
                "2012|Physics|David J. Wineland\n" +
                "1990|Peace|Mikhail Gorbachev\n" +
                "2002|Physics|Raymond Davis Jr.\n" +
                "1986|Chemistry|Dudley R. Herschbach\n" +
                "2013|Economics|Lars Peter Hansen\n" +
                "1907|Peace|Louis Renault\n" +
                "1965|Physics|Richard P. Feynman\n" +
                "1903|Medicine|Niels Ryberg Finsen\n" +
                "1926|Peace|Aristide Briand\n" +
                "1945|Peace|Cordell Hull\n" +
                "1958|Medicine|Edward Tatum\n" +
                "1936|Peace|Carlos Saavedra Lamas\n" +
                "1954|Physics|Max Born\n" +
                "1933|Physics|Paul A.M. Dirac\n" +
                "2004|Peace|Wangari Maathai\n" +
                "1909|Physics|Ferdinand Braun\n" +
                "1980|Medicine|George D. Snell\n" +
                "1989|Peace|The 14th Dalai Lama\n" +
                "1975|Physics|Ben R. Mottelson\n" +
                "1950|Peace|Ralph Bunche\n" +
                "1984|Peace|Desmond Tutu\n" +
                "1969|Medicine|Max DelbrÃ¼ck\n" +
                "1991|Chemistry|Richard R. Ernst\n" +
                "1921|Literature|Anatole France\n" +
                "1960|Physics|Donald A. Glaser\n" +
                "1992|Medicine|Edwin G. Krebs\n" +
                "1994|Medicine|Martin Rodbell\n" +
                "1972|Physics|Robert Schrieffer\n" +
                "1922|Physics|Niels Bohr\n" +
                "1956|Chemistry|Nikolay Semenov\n" +
                "1927|Peace|Ludwig Quidde\n" +
                "1974|Chemistry|Paul J. Flory\n" +
                "2015|Chemistry|Tomas Lindahl\n" +
                "1908|Peace|Fredrik Bajer\n" +
                "1980|Economics|Lawrence R. Klein\n" +
                "1981|Medicine|Torsten N. Wiesel\n" +
                "1969|Literature|Samuel Beckett\n" +
                "2002|Medicine|Sydney Brenner\n" +
                "1971|Literature|Pablo Neruda\n" +
                "1958|Physics|Igor Y. Tamm\n" +
                "1945|Physics|Wolfgang Pauli\n" +
                "1966|Literature|Shmuel Agnon\n" +
                "2000|Medicine|Eric R. Kandel\n" +
                "2006|Economics|Edmund S. Phelps\n" +
                "2010|Economics|Dale T. Mortensen\n" +
                "2007|Physics|Peter GrÃ¼nberg\n" +
                "2009|Chemistry|Ada Yonath\n" +
                "2007|Physics|Albert Fert\n" +
                "2006|Literature|Orhan Pamuk\n" +
                "2009|Medicine|Carol W. Greider\n" +
                "1989|Chemistry|Thomas R. Cech\n" +
                "1973|Physics|Brian D. Josephson\n" +
                "1949|Medicine|Egas Moniz\n" +
                "1970|Peace|Norman Borlaug\n" +
                "1925|Physics|James Franck\n" +
                "1929|Medicine|Christiaan Eijkman\n" +
                "1978|Physics|Arno Penzias\n" +
                "1922|Medicine|Otto Meyerhof\n" +
                "1993|Peace|F.W. de Klerk\n" +
                "2006|Peace|Muhammad Yunus\n" +
                "1967|Chemistry|George Porter\n" +
                "1991|Physics|Pierre-Gilles de Gennes\n" +
                "1975|Physics|Aage N. Bohr\n" +
                "2002|Literature|Imre KertÃ©sz\n" +
                "1903|Chemistry|Svante Arrhenius\n" +
                "1988|Economics|Maurice Allais\n" +
                "2014|Medicine|May-Britt Moser\n" +
                "1966|Literature|Nelly Sachs\n" +
                "1981|Physics|Nicolaas Bloembergen\n" +
                "1912|Peace|Elihu Root\n" +
                "1914|Physics|Max von Laue\n" +
                "2005|Economics|Robert J. Aumann\n" +
                "1928|Literature|Sigrid Undset\n" +
                "1996|Chemistry|Sir Harold Kroto\n" +
                "1988|Literature|Naguib Mahfouz\n" +
                "1995|Medicine|Edward B. Lewis\n" +
                "1919|Literature|Carl Spitteler\n" +
                "2000|Physics|Jack S. Kilby\n" +
                "1957|Physics|Chen Ning Yang\n" +
                "2014|Chemistry|William Moerner\n" +
                "1994|Peace|Yasser Arafat\n" +
                "1988|Medicine|George H. Hitchings\n" +
                "1965|Medicine|FranÃ§ois Jacob\n" +
                "1945|Medicine|Ernst B. Chain\n" +
                "1926|Physics|Jean Baptiste Perrin\n" +
                "1933|Physics|Erwin SchrÃ¶dinger\n" +
                "1995|Medicine|Eric F. Wieschaus\n" +
                "1986|Literature|Wole Soyinka\n" +
                "2009|Peace|Barack Obama\n" +
                "1954|Chemistry|Linus Pauling\n" +
                "1989|Physics|Hans G. Dehmelt\n" +
                "1951|Physics|Ernest T.S. Walton\n" +
                "1996|Physics|Douglas D. Osheroff\n" +
                "2015|Chemistry|Paul L. Modrich\n" +
                "1972|Economics|Kenneth J. Arrow\n" +
                "1915|Chemistry|Richard WillstÃ¤tter\n" +
                "1990|Chemistry|Elias James Corey\n" +
                "1915|Physics|William Bragg\n" +
                "1934|Medicine|George H. Whipple\n" +
                "2015|Medicine|William C. Campbell\n" +
                "1947|Peace|Friends Service Council\n" +
                "2001|Economics|George A. Akerlof\n" +
                "2000|Medicine|Arvid Carlsson\n" +
                "1909|Chemistry|Wilhelm Ostwald\n" +
                "2009|Physics|Willard S. Boyle\n" +
                "1983|Literature|William Golding\n" +
                "1987|Chemistry|Charles J. Pedersen\n" +
                "2013|Chemistry|Arieh Warshel\n" +
                "1984|Physics|Simon van der Meer\n" +
                "1904|Medicine|Ivan Pavlov\n" +
                "1917|Literature|Karl Gjellerup\n" +
                "2000|Physics|Herbert Kroemer\n" +
                "1925|Chemistry|Richard Zsigmondy\n" +
                "1937|Medicine|Albert Szent-GyÃ¶rgyi\n" +
                "1970|Physics|Louis NÃ©el\n" +
                "1931|Peace|Jane Addams\n" +
                "1961|Peace|Dag HammarskjÃ¶ld\n" +
                "1922|Literature|Jacinto Benavente\n" +
                "1937|Physics|Clinton Davisson\n" +
                "1990|Economics|William F. Sharpe\n" +
                "2003|Economics|Clive W.J. Granger\n" +
                "1920|Chemistry|Walther Nernst\n" +
                "1945|Medicine|Sir Howard Florey\n" +
                "1986|Economics|James M. Buchanan Jr.\n" +
                "1986|Physics|Ernst Ruska\n" +
                "1963|Physics|Eugene Wigner\n" +
                "1996|Literature|Wislawa Szymborska\n" +
                "2000|Economics|Daniel L. McFadden\n" +
                "2005|Peace|International Atomic Energy Agency\n" +
                "1946|Peace|Emily Greene Balch\n" +
                "1995|Peace|Joseph Rotblat\n" +
                "2000|Chemistry|Alan Heeger\n" +
                "1927|Chemistry|Heinrich Wieland\n" +
                "1958|Peace|Georges Pire\n" +
                "1984|Medicine|Niels K. Jerne\n" +
                "1951|Chemistry|Edwin M. McMillan\n" +
                "1913|Literature|Rabindranath Tagore\n" +
                "1990|Medicine|E. Donnall Thomas\n" +
                "1952|Medicine|Selman A. Waksman\n" +
                "1998|Peace|John Hume\n" +
                "1991|Medicine|Bert Sakmann\n" +
                "1970|Physics|Hannes AlfvÃ©n\n" +
                "2003|Economics|Robert F. Engle III\n" +
                "1990|Physics|Henry W. Kendall\n" +
                "1975|Medicine|David Baltimore\n" +
                "2012|Medicine|John B. Gurdon\n" +
                "1961|Literature|Ivo Andric\n" +
                "1945|Literature|Gabriela Mistral\n" +
                "2002|Chemistry|Koichi Tanaka\n" +
                "1935|Medicine|Hans Spemann\n" +
                "1964|Literature|Jean-Paul Sartre\n" +
                "1961|Physics|Rudolf MÃ¶ssbauer\n" +
                "2006|Medicine|Craig C. Mello\n" +
                "1978|Medicine|Daniel Nathans\n" +
                "1902|Peace|Albert Gobat\n" +
                "2014|Literature|Patrick Modiano\n" +
                "1995|Physics|Frederick Reines\n" +
                "1946|Chemistry|Wendell M. Stanley\n" +
                "1981|Chemistry|Kenichi Fukui\n" +
                "1986|Peace|Elie Wiesel\n" +
                "1983|Peace|Lech Walesa\n" +
                "2008|Medicine|Luc Montagnier\n" +
                "1953|Physics|Frits Zernike\n" +
                "2003|Physics|Alexei A. Abrikosov\n" +
                "1976|Chemistry|William Lipscomb\n" +
                "2014|Economics|Jean Tirole\n" +
                "1953|Peace|George C. Marshall\n" +
                "2008|Literature|Jean-Marie Gustave Le ClÃ©zio\n" +
                "1905|Medicine|Robert Koch\n" +
                "1932|Physics|Werner Heisenberg\n" +
                "1979|Physics|Abdus Salam\n" +
                "1997|Literature|Dario Fo\n" +
                "1994|Economics|John C. Harsanyi\n" +
                "1972|Physics|John Bardeen\n" +
                "1993|Medicine|Richard J. Roberts\n" +
                "1996|Peace|JosÃ© Ramos-Horta\n" +
                "1969|Chemistry|Odd Hassel\n" +
                "1943|Physics|Otto Stern\n" +
                "1962|Medicine|James Watson\n" +
                "1950|Literature|Bertrand Russell\n" +
                "1955|Chemistry|Vincent du Vigneaud\n" +
                "1986|Physics|Heinrich Rohrer\n" +
                "1996|Peace|Carlos Filipe Ximenes Belo\n" +
                "1937|Peace|Robert Cecil\n" +
                "1994|Physics|Clifford G. Shull\n" +
                "2014|Physics|Isamu Akasaki\n" +
                "2007|Peace|Al Gore\n" +
                "1991|Peace|Aung San Suu Kyi\n" +
                "1972|Medicine|Gerald M. Edelman\n" +
                "2013|Economics|Eugene F. Fama\n" +
                "1908|Medicine|Ilya Mechnikov\n" +
                "1961|Physics|Robert Hofstadter\n" +
                "1993|Peace|Nelson Mandela\n" +
                "1990|Economics|Merton H. Miller\n" +
                "1974|Peace|Eisaku Sato\n" +
                "2004|Chemistry|Irwin Rose\n" +
                "1926|Literature|Grazia Deledda\n" +
                "2004|Chemistry|Aaron Ciechanover\n" +
                "2014|Chemistry|Stefan Hell\n" +
                "1993|Chemistry|Kary B. Mullis\n" +
                "1903|Physics|Marie Curie\n" +
                "2005|Physics|Theodor W. HÃ¤nsch\n" +
                "1950|Chemistry|Otto Diels\n" +
                "1981|Medicine|David H. Hubel\n" +
                "1999|Peace|MÃ©decins Sans FrontiÃ¨res\n" +
                "1934|Peace|Arthur Henderson\n" +
                "1965|Medicine|Jacques Monod\n" +
                "1987|Economics|Robert M. Solow\n" +
                "1955|Physics|Polykarp Kusch\n" +
                "1984|Economics|Richard Stone\n" +
                "1908|Peace|Klas Pontus Arnoldson\n" +
                "1901|Medicine|Emil von Behring\n" +
                "1995|Chemistry|Paul J. Crutzen\n" +
                "2010|Physics|Andre Geim\n" +
                "2008|Physics|Makoto Kobayashi\n" +
                "2001|Physics|Wolfgang Ketterle\n" +
                "1963|Chemistry|Karl Ziegler\n" +
                "2010|Economics|Peter A. Diamond\n" +
                "1980|Literature|Czeslaw Milosz\n" +
                "1914|Chemistry|Theodore W. Richards\n" +
                "1958|Physics|Pavel A. Cherenkov\n" +
                "1998|Medicine|Louis J. Ignarro\n" +
                "2014|Physics|Shuji Nakamura\n" +
                "1949|Physics|Hideki Yukawa\n" +
                "2008|Medicine|FranÃ§oise BarrÃ©-Sinoussi\n" +
                "1997|Chemistry|Jens C. Skou\n" +
                "2003|Medicine|Sir Peter Mansfield\n" +
                "1968|Medicine|Robert W. Holley\n" +
                "2007|Economics|Roger B. Myerson\n" +
                "1962|Literature|John Steinbeck\n" +
                "1925|Peace|Sir Austen Chamberlain\n" +
                "1960|Literature|Saint-John Perse\n" +
                "1929|Chemistry|Hans von Euler-Chelpin\n" +
                "1978|Economics|Herbert A. Simon\n" +
                "1921|Peace|Christian Lange\n" +
                "1958|Physics|IlÂ´ja M. Frank\n" +
                "1987|Peace|Oscar Arias SÃ¡nchez\n" +
                "1932|Medicine|Edgar Adrian\n" +
                "1938|Peace|Nansen International Office for Refugees\n" +
                "1987|Chemistry|Jean-Marie Lehn\n" +
                "1903|Physics|Pierre Curie\n" +
                "1944|Medicine|Herbert S. Gasser\n" +
                "1997|Physics|Claude Cohen-Tannoudji\n" +
                "1914|Medicine|Robert BÃ¡rÃ¡ny\n" +
                "1925|Peace|Charles G. Dawes\n" +
                "1964|Chemistry|Dorothy Crowfoot Hodgkin\n" +
                "1972|Medicine|Rodney R. Porter\n" +
                "1929|Literature|Thomas Mann\n" +
                "1930|Peace|Nathan SÃ¶derblom\n" +
                "1906|Chemistry|Henri Moissan\n" +
                "2013|Chemistry|Martin Karplus\n" +
                "1947|Medicine|Gerty Cori\n" +
                "1959|Medicine|Severo Ochoa\n" +
                "1974|Medicine|George E. Palade\n" +
                "2009|Chemistry|Thomas A. Steitz\n" +
                "1985|Medicine|Joseph L. Goldstein\n" +
                "1904|Chemistry|Sir William Ramsay\n" +
                "1979|Literature|Odysseus Elytis\n" +
                "1999|Medicine|GÃ¼nter Blobel\n" +
                "2015|Economics|Angus Deaton\n" +
                "1998|Medicine|Ferid Murad\n" +
                "1946|Chemistry|James B. Sumner\n" +
                "2005|Chemistry|Yves Chauvin\n" +
                "1992|Peace|Rigoberta MenchÃº Tum\n" +
                "1981|Chemistry|Roald Hoffmann\n" +
                "1960|Peace|Albert Lutuli\n" +
                "1910|Peace|Permanent International Peace Bureau\n" +
                "1928|Chemistry|Adolf Windaus\n" +
                "1955|Literature|HalldÃ³r Laxness\n" +
                "1963|Medicine|Alan L. Hodgkin\n" +
                "1973|Peace|Le Duc Tho\n" +
                "2003|Physics|Vitaly L. Ginzburg\n" +
                "2009|Physics|Charles K. Kao\n" +
                "1934|Chemistry|Harold C. Urey\n" +
                "2001|Medicine|Sir Paul Nurse\n" +
                "2012|Peace|European Union\n" +
                "1909|Literature|Selma LagerlÃ¶f\n" +
                "2001|Peace|Kofi Annan\n" +
                "1980|Physics|Val Fitch\n" +
                "1992|Chemistry|Rudolph A. Marcus\n" +
                "1951|Peace|LÃ©on Jouhaux\n" +
                "2000|Peace|Kim Dae-jung\n" +
                "1975|Physics|James Rainwater\n" +
                "1982|Medicine|Sune K. BergstrÃ¶m\n" +
                "1913|Medicine|Charles Richet\n" +
                "1931|Chemistry|Friedrich Bergius\n" +
                "2005|Economics|Thomas C. Schelling\n" +
                "2011|Economics|Thomas J. Sargent\n" +
                "1987|Literature|Joseph Brodsky\n" +
                "2011|Peace|Leymah Gbowee\n" +
                "1975|Economics|Leonid Vitaliyevich Kantorovich\n" +
                "2013|Literature|Alice Munro\n" +
                "1912|Literature|Gerhart Hauptmann\n" +
                "1999|Economics|Robert A. Mundell\n" +
                "1988|Peace|United Nations Peacekeeping Forces\n" +
                "1970|Literature|Alexandr Solzhenitsyn\n" +
                "1927|Peace|Ferdinand Buisson\n" +
                "1946|Physics|Percy W. Bridgman\n" +
                "1951|Chemistry|Glenn T. Seaborg\n" +
                "1982|Medicine|John R. Vane\n" +
                "1955|Medicine|Hugo Theorell\n" +
                "1902|Medicine|Ronald Ross\n" +
                "1905|Chemistry|Adolf von Baeyer\n" +
                "2012|Economics|Lloyd S. Shapley\n" +
                "1963|Peace|League of Red Cross Societies\n" +
                "1949|Chemistry|William F. Giauque\n" +
                "1973|Medicine|Konrad Lorenz\n" +
                "1933|Literature|Ivan Bunin\n" +
                "1973|Physics|Leo Esaki\n" +
                "1968|Physics|Luis Alvarez\n" +
                "1910|Medicine|Albrecht Kossel\n" +
                "1987|Physics|K. Alex MÃ¼ller\n" +
                "1967|Chemistry|Ronald G.W. Norrish\n" +
                "2001|Peace|United Nations\n" +
                "1991|Medicine|Erwin Neher\n" +
                "1946|Chemistry|John H. Northrop\n" +
                "2013|Medicine|Thomas C. SÃ¼dhof\n" +
                "1967|Medicine|Haldan K. Hartline\n" +
                "1982|Physics|Kenneth G. Wilson\n" +
                "1956|Medicine|Dickinson W. Richards\n" +
                "1987|Medicine|Susumu Tonegawa\n" +
                "2003|Medicine|Paul C. Lauterbur\n" +
                "2009|Economics|Oliver E. Williamson\n" +
                "2004|Physics|H. David Politzer\n" +
                "1994|Peace|Yitzhak Rabin\n" +
                "1962|Chemistry|Max F. Perutz\n" +
                "1907|Physics|Albert A. Michelson\n" +
                "1986|Chemistry|John C. Polanyi\n" +
                "1904|Peace|Institute of International Law\n" +
                "1995|Medicine|Christiane NÃ¼sslein-Volhard\n" +
                "1920|Physics|Charles Edouard Guillaume\n" +
                "1973|Chemistry|Ernst Otto Fischer\n" +
                "1962|Medicine|Maurice Wilkins\n" +
                "1986|Chemistry|Yuan T. Lee\n" +
                "1994|Economics|Reinhard Selten\n" +
                "1979|Economics|Theodore W. Schultz\n" +
                "1964|Medicine|Feodor Lynen\n" +
                "1936|Medicine|Sir Henry Dale\n" +
                "1953|Chemistry|Hermann Staudinger\n" +
                "1968|Chemistry|Lars Onsager\n" +
                "1927|Physics|C.T.R. Wilson\n" +
                "1967|Chemistry|Manfred Eigen\n" +
                "1945|Medicine|Sir Alexander Fleming\n" +
                "1998|Peace|David Trimble\n" +
                "2008|Economics|Paul Krugman\n" +
                "1915|Literature|Romain Rolland\n" +
                "1952|Physics|Felix Bloch\n" +
                "1920|Medicine|August Krogh\n" +
                "1998|Physics|Daniel C. Tsui\n" +
                "1970|Chemistry|Luis Leloir\n" +
                "1913|Physics|Heike Kamerlingh Onnes\n" +
                "1973|Medicine|Nikolaas Tinbergen\n" +
                "1965|Chemistry|Robert B. Woodward\n" +
                "1904|Literature|JosÃ© Echegaray\n" +
                "1997|Peace|Jody Williams\n" +
                "1977|Medicine|Andrew V. Schally\n" +
                "1946|Literature|Hermann Hesse\n" +
                "1922|Medicine|Archibald V. Hill\n" +
                "1969|Medicine|Alfred D. Hershey\n" +
                "1992|Literature|Derek Walcott\n" +
                "1993|Physics|Russell A. Hulse\n" +
                "1998|Chemistry|Walter Kohn\n" +
                "1981|Economics|James Tobin\n" +
                "1973|Medicine|Karl von Frisch\n" +
                "1976|Peace|Betty Williams\n" +
                "1975|Chemistry|Vladimir Prelog\n" +
                "2003|Physics|Anthony J. Leggett\n" +
                "2004|Economics|Edward C. Prescott\n" +
                "1983|Economics|Gerard Debreu\n" +
                "1948|Medicine|Paul MÃ¼ller\n" +
                "1938|Physics|Enrico Fermi\n" +
                "1923|Physics|Robert A. Millikan\n" +
                "2010|Peace|Liu Xiaobo\n" +
                "1989|Chemistry|Sidney Altman\n" +
                "1978|Peace|Anwar al-Sadat\n" +
                "1953|Medicine|Fritz Lipmann\n" +
                "1944|Physics|Isidor Isaac Rabi\n" +
                "2000|Literature|Gao Xingjian\n" +
                "1996|Physics|Robert C. Richardson\n" +
                "1920|Peace|LÃ©on Bourgeois\n" +
                "1978|Physics|Pyotr Kapitsa\n" +
                "2014|Physics|Hiroshi Amano\n" +
                "1972|Literature|Heinrich BÃ¶ll\n" +
                "1990|Medicine|Joseph E. Murray\n" +
                "1953|Literature|Winston Churchill\n" +
                "1949|Literature|William Faulkner\n" +
                "1997|Physics|William D. Phillips\n" +
                "1982|Literature|Gabriel GarcÃ\u00ADa MÃ¡rquez\n" +
                "1958|Medicine|George Beadle\n" +
                "1977|Literature|Vicente Aleixandre\n" +
                "2014|Peace|Kailash Satyarthi\n" +
                "1908|Medicine|Paul Ehrlich\n" +
                "1996|Medicine|Rolf M. Zinkernagel\n" +
                "2009|Economics|Elinor Ostrom\n" +
                "1969|Medicine|Salvador E. Luria\n" +
                "1975|Medicine|Howard M. Temin\n" +
                "1995|Chemistry|Mario J. Molina\n" +
                "1953|Medicine|Hans Krebs\n" +
                "1980|Physics|James Cronin\n" +
                "1977|Economics|James E. Meade\n" +
                "2014|Peace|Malala Yousafzai\n" +
                "1972|Economics|John R. Hicks\n" +
                "2013|Medicine|Randy W. Schekman\n" +
                "2008|Physics|Yoichiro Nambu\n" +
                "1901|Peace|FrÃ©dÃ©ric Passy\n" +
                "1986|Physics|Gerd Binnig\n" +
                "1963|Medicine|Andrew F. Huxley\n" +
                "1946|Peace|John R. Mott\n" +
                "1983|Chemistry|Henry Taube\n" +
                "1969|Physics|Murray Gell-Mann\n" +
                "2010|Physics|Konstantin Novoselov\n" +
                "1969|Peace|International Labour Organization\n" +
                "1931|Medicine|Otto Warburg\n" +
                "2002|Medicine|H. Robert Horvitz\n" +
                "1938|Medicine|Corneille Heymans\n" +
                "2005|Physics|John L. Hall\n" +
                "2010|Economics|Christopher A. Pissarides\n" +
                "1902|Physics|Pieter Zeeman\n" +
                "1933|Medicine|Thomas H. Morgan\n" +
                "1989|Economics|Trygve Haavelmo\n" +
                "1990|Literature|Octavio Paz\n" +
                "1911|Chemistry|Marie Curie\n" +
                "1931|Chemistry|Carl Bosch\n" +
                "1908|Literature|Rudolf Eucken\n" +
                "1978|Physics|Robert Woodrow Wilson\n" +
                "1911|Peace|Alfred Fried\n" +
                "1989|Medicine|J. Michael Bishop\n" +
                "1978|Medicine|Werner Arber\n" +
                "1996|Medicine|Peter C. Doherty\n" +
                "1952|Peace|Albert Schweitzer\n" +
                "2015|Peace|Tunisian National Dialogue Quartet\n" +
                "1923|Chemistry|Fritz Pregl\n" +
                "1998|Medicine|Robert F. Furchgott\n" +
                "1984|Literature|Jaroslav Seifert\n" +
                "1964|Medicine|Konrad Bloch\n" +
                "1934|Literature|Luigi Pirandello\n" +
                "1924|Medicine|Willem Einthoven\n" +
                "1986|Medicine|Stanley Cohen\n" +
                "1994|Medicine|Alfred G. Gilman\n" +
                "1990|Physics|Richard E. Taylor\n" +
                "2012|Physics|Serge Haroche\n" +
                "1996|Chemistry|Richard E. Smalley\n" +
                "1939|Chemistry|Leopold Ruzicka\n" +
                "1921|Physics|Albert Einstein\n" +
                "2007|Peace|Intergovernmental Panel on Climate Change\n" +
                "1947|Medicine|Bernardo Houssay\n" +
                "1959|Physics|Emilio SegrÃ¨\n" +
                "2001|Chemistry|K. Barry Sharpless\n" +
                "2011|Physics|Adam G. Riess\n" +
                "1948|Physics|Patrick M.S. Blackett\n" +
                "1963|Physics|J. Hans D. Jensen\n" +
                "1963|Medicine|Sir John Eccles\n" +
                "1977|Medicine|Rosalyn Yalow\n" +
                "1929|Chemistry|Arthur Harden\n" +
                "1997|Economics|Myron S. Scholes\n" +
                "1998|Chemistry|John Pople\n" +
                "1972|Chemistry|William H. Stein\n" +
                "1935|Chemistry|FrÃ©dÃ©ric Joliot\n" +
                "1937|Physics|George Paget Thomson\n" +
                "1947|Peace|American Friends Service Committee\n" +
                "1938|Literature|Pearl Buck\n" +
                "2004|Physics|Frank Wilczek\n" +
                "1971|Medicine|Earl W. Sutherland, Jr.\n" +
                "1988|Medicine|Gertrude B. Elion\n" +
                "1938|Chemistry|Richard Kuhn\n" +
                "2002|Peace|Jimmy Carter\n" +
                "2013|Chemistry|Michael Levitt\n" +
                "1903|Physics|Henri Becquerel\n" +
                "2001|Economics|A. Michael Spence\n" +
                "1918|Chemistry|Fritz Haber\n" +
                "1954|Medicine|Frederick C. Robbins\n" +
                "1916|Literature|Verner von Heidenstam\n" +
                "1906|Physics|J.J. Thomson\n" +
                "1917|Literature|Henrik Pontoppidan\n" +
                "2012|Chemistry|Brian K. Kobilka\n" +
                "1936|Medicine|Otto Loewi\n" +
                "2012|Economics|Alvin E. Roth\n" +
                "2011|Medicine|Jules A. Hoffmann\n" +
                "1984|Physics|Carlo Rubbia\n";
        //"yr|subject|winner\n"
        PissService pissService = new PissService();
        ArrayList<Piss> pisses = new ArrayList<>();
        String[] line = input.split("\n");
        for (int i = 1; i < line.length; i++) {
            String humus = line[i].replace("|", ";");
            String[] linePiss = humus.split(";");
            Piss piss = new Piss(Integer.parseInt(linePiss[0]), linePiss[1], linePiss[2]);
            pisses.add(piss);
        }
        //pissService.getFirstWinners(pisses);
        //pissService.barackObama(pisses);
        //pissService.wW1(pisses);
        // pissService.wW2(pisses);
        //pissService.firstEconomic(pisses);
        //pissService.getWinnersAfterEU(pisses);
        //pissService.getAll(pisses);
        pissService.getTwoTimerChamp(pisses);
    }
}
