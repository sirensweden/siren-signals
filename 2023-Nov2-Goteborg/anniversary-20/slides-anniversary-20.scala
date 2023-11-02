//> using lib "taggy:taggy:0.0.5,url=https://github.com/bjornregnell/taggy/releases/download/v0.0.5/taggy_3-0.0.5.jar"
//> using scala "3.3.0"

import taggy.*

@main def makeSlides = 
  allSlides.toPdf(out = "AI-taking-over", dir = "tex")

  document("AI och högre utbildning")(higherEducationSlides)
    .toPdf(out = "AI-higher-education", dir = "tex")

def allSlides = document("När AI tar över..."):
  frame("Björn Regnell enligt ChatGPT:"):
    p("""
    Björn Regnell är professor i mjukvaruteknik vid Lunds universitet i Sverige.
    Han har arbetat på universitetet sedan *1995* och är en känd expert inom kravteknik, 
    *mjukvarutestning* och förbättring av mjukvaruprocesser. Han har publicerat mycket 
    inom sitt område och har mottagit flera priser för sina forskningsinsatser.""")
    space(4)
    p("Felaktigheter:")
    p("1995 är fel och bara ca 5 av ca 100 artiklar inom testning")
    p("https://cs.lth.se/bjorn-regnell")
    
  frame("Hallå ChatGPT..."):
    image("../img/chatgpt-error", width = 1.05)
    space(2)
    p("Man kan inte få allt...")
    space(2)
      
  frame("Vinnaren av fototävling..."):
    image("../img/ai-photo-winner", width = 0.45)
    p("\\pause ... avsäger sig priset \\hfill \\copyright~Boris Eldagsen")
    p("https://www.theguardian.com/technology/2023/apr/17/photographer-admits-prize-winning-image-was-ai-generated")

  frame("Hur funkar en AI?"):
    p("Exempel på ett *riktigt simpelt* neuralt nätverk:")
    itemize:
      p("https://github.com/bjornregnell/scai")
    p("En fördomsfull **binär klassificerare** av kön givet längd och vikt.")
    space(1)
    p("**Träningsdata**:")
    p("115, 66 : 1      \\hfill Female")
    p("175, 78 : 0      \\hfill Male")
    p("205, 72 : 0      \\hfill Male")
    p("120, 67 : 1      \\hfill Female")
    space(1)
    p("**Testdata**: \\hfill *korrekt klassificering*")
    p("167, 73 : 0 \\hfill Male")
    p("105, 67 : 1 \\hfill Female")
    p("120, 72 : 1 \\hfill Female")
    p("143, 67 : 0 \\hfill Male")
    p("**130, 66** : 0 \\hfill **Male**")

  frame("Träningen ska hitta en binär klassificering"):
    image("../img/data", width = 1.05)


  frame("En nervcell i en hjärna"):
    image("../img/neuron", width = 0.85)
    p("Wikipedia: 'Nervcell'") 

  frame("En enkel modell av en hjärncell: en artificiell neuron"):
    image("../img/artificial-neuron", width = 0.85)
    code(" output = S(x1*w1 + x2*w2 + x3*w3 + bias)") 
    textSize(8,11)
    space(1)
    p("\\hfill Warren McCull \\&  Walter Pitts (1943)")
  
  frame("Ett litet nätverk av neuroner"):
    image("../img/ai-network", width = 0.95)
    p("Ett nätverk med 3 lager, 6 neuroner, 20 parametrar") 

  frame("Hur går träningen till?"):
    p("En enkel träningsalgoritm:")
    enumerate:
      p("Ge alla parametrar ett slumpmässigt startvärde.")
      p("Ge ny träningsdata som input.")
      p("Beräkna **felet**: ''avståndet'' mellan output och korrekt värde.")
      p("Välj en slumpmässig neuron och **justera** dess parametrar slumpmässigt; förändringsstorleken styrs av en *lärfaktor*.")
      p("Beräkna nya felet efter justeringen.")
      p("**Om** felet är mindre efter justering **så** behåll de nya parametrarna **annars** återställ parametrarna.")
      p("Upprepa från punkt 2 lagom många gånger.")
    p("Testa träningsalgoritmen här:")
    p("https://scastie.scala-lang.org/vVvDotCzRUyyAWg5lec9Jg")


  // Facebooks språkmodell LaMA:
  // 2048 GPU A100 80Gig VRAM (kostar 150kkr per GPU) i 21 dagar 10^12 ord, 65 10^9 
  // https://store.nanoporetech.com/eu/nvidia-dgx-station-a100.html
  frame("Vad skiljer vårt simpla nätverk från ChatGPT?"):
    p("Den simpla binära könsklassificeraren:")
    itemize:
      p("6 neuroner, 20 parametrar, tränad på 4 datapunkter")
    p("ChatGPT:")
    itemize:
      p("175 miljarder parametrar, tränad på **jättemycket** data \\\\(300 miljarder ord tränad med 10,000 specialdatorer)")
      p("Baserad på en **språkmodell** som tar ord som indata och ger troligaste efterföljande ord som utdata.")
      p("Vad betyder akronymen GPT?")
      itemize:
        p("**Generative**: Kan generera ny utdata medan den tar hänsyn till ett existerande sammanhang.")
        p("**Pre-trained**: Har i förväg tränats på jättestora textmängder, inkl. hela Wikipedia, och allmänt tillgängliga internet.")
        // Corpus CommonCrawl stod för 60% av indatan till GPT-3, Wikipedia 3% är 3 miljarder ord
        p("**Transformer**: Kan hantera sekvenser av ord, värdera kopplingar mellan ord och avgöra vilka ord som är viktigast.")

  frame("Inga billiga datorer..."):
    image("../img/berzelius", width = 1.15)

  frame("AI-forskare har förfinat träningen i många steg"):
    image("../img/chatgpt-steps", width = 1.05)
    p("https://openai.com/blog/chatgpt")

  frame("Några problem med dagens maskininlärning"):
    p("Även om den *verkar* smart så *förstår* den ingenting!")
    space(1)
    enumerate:
      p("**Bias**: fördomsfull AI.")
      p("**Överträning**: kan ej generalisera bortom träningsdata.")
      p("Det är inte lätt att få stora modeller att bli bra.")
      p("Kan plötsligt börja ''**hallucinera**'' -- spotta ur sig hittepå.")
      p("Svårt att förhindra olämplig eller rent oacceptabel utdata.")
      p("Kan inte själv avgöra vad som är rimligt.")
      p("Är väldigt övertygande även när den har helt fel.")
      p("Svårt genomskåda hur nätverket fungerar: *explainability*.")

  frame("När tar AI över?"):
    p("AI är redan här:")
    itemize:
      p("Bättre sökresultat, massövervakning, röstigenkänning, ...")
      p("Bättre diagnostik i sjukvården (hitta cancer).")
      p("Bättre på att undvika olyckor i trafiken.")
      p("AI som assistent. Skapa nya bilder från text, skriva kod, ...")
      p("Studenter försöker fuska på tentan med hjälp av ChatGPT.")
    p("Vad händer när fler områden tas över av AI?")
    itemize:
      p("Omstrukturering av arbetsmarknaden: försvinner mitt jobb?")
      itemize:
        p("Det är nog inte en **AI** som kommer ta ditt jobb utan **andra människor** som är bättre på att *dra nytta av* AI än du.")
      p("Människans viktiga färdighet: att bli en **skicklig prompter**.")
      p("Hur ska vi förhindra illvillig användning av AI?")
      p("Vem har makten över AI? De stora dataföretagen? Staten?")
      p("Vad händer med demokratin? Vilket samhälle vill vi ha?")

  frame("Öppna AI-modeller tillgängliga för alla"):
    itemize:
      p("Hemlig AI kan ge konkurrensfördel")
      p("Öppen AI kan utvecklas snabbare i gemenskap")
      p("AI-modeller som öppen källkod blir samhällets infrastruktur")
    space(2)
    p("https://huggingface.co/models")
    space(1)
    p("Sök t.ex. efter modellen bart-large-mnli.")
    p("Vilken är huvudstaden i Skåne? Malmö, Lund, Stockholm")
      //https://huggingface.co/models
      //https://huggingface.co/facebook/bart-large-mnli?candidateLabels=malm%C3%B6%2C+lund%2C+stockholm&multiClass=false&text=Vilken+%C3%A4r+huvudstaden+i+sk%C3%A5ne%3F
    
  higherEducationSlides

  frame("Länkar"):
    itemize:
      p("https://youtu.be/BP5GPzV9ICQ")
      p("https://github.com/bjornregnell/AI-taking-over")
      p("https://github.com/bjornregnell/scai")
      p("https://openai.com/blog/chatgpt")
      p("https://huggingface.co/models")
      p("https://www.ai.lu.se/")
      p("https://www.lu.se/artikel/chatta-med-botten")
      p("https://universitetslararen.se/2023/03/29/forsta-fuskaren-akte-fast-sa-vad-hander-nu/")
      p("https://universitetslararen.se/2023/03/29/omstart-for-hogskolan-med-artificiell-intelligens/")

def higherEducationSlides: TreeContext =
  frame("AI inom högre utbildning:"):
    itemize:
      p("Anden är ur flaskan!")
      p("Digitalisering med AI kommer att genomsyra samhället!") 
      p("Högre utbildning måste utvecklas!")
      itemize:
        p("Utbildningsprogram")
        p("Kursplaner")
        p("Pedagogik")
        p("Examination")
    
      p("**Alla** anställda och **alla** studenter behöver lära sig ...")
      itemize:
        p("att programmera")
        p("att förstå hur en AI funkar")
        p("att dra nytta av AI")
        p("att förhindra dålig användning av AI")

  frame("Studenterna har rätt att få djupa kunskaper om:"):
    itemize:
      p("Hur använda AI på ett bra sätt för att **främja studierna**")
      itemize:
        p("AI som en outtröttlig pedagog och coach")
      p("Hur använda AI i den framtida **yrkesrollen**")
      itemize:
        p("Människa+AI för att öka produktivitet och kvalitet")
      p("Begränsningar och **risker** med AI")
      itemize:
        p("Alla medborgares aktiva deltagande i utvecklingen")
  
  frame("AI och pedagogik"):
    itemize:
      p("Förändrad syn på kunskap och lärarens roll")
    image("../img/bloom", width = 1.05)
    p("Wikipedia: ''Blooms taxonomi'' för olika nivåer av kunskap")

  frame("Förändrad pedagogik och examination"):
    itemize: 
      p("Pedagogik:")
      itemize:
        p("Förståelse för hur AI påverkar mitt ämne")
        p("Dra nytta av AI som pedagogiskt verktyg")
        p("Vem har tillgång till AI? \\\\ ChatGPT ''Plus'' kostar pengar...")
      p("Examination: ")
      itemize:
        p("https://universitetslararen.se/2023/03/29/forsta-fuskaren-akte-fast-sa-vad-hander-nu/")
        p("Vi ska inte examinera AI:ns utan *studentens* kunskaper.")
        p("Vi behöver i högre grad examinera **muntligen**")
        p("Examination behöver ske på **högre kunskapsnivå**")
        p("Även examinera förmågan att **använda** AI")
        p("Även examinera förmågan att **värdera** utdata från AI")

  frame("Frågeställningar för diskussion"):
    enumerate:
      p("Hur ska vi organisera **fortbildning** av lärare?")
      enumerate:
        p("Allmänbildning om AI-teknik: funktion och användning")
        p("AI-teknik specifikt för ett visst ämne i en viss disciplin")
      p("Hur påverkar AI mitt specifika **ämne**?")
      enumerate:
        p("Innehåll?")
        p("Pedagogik?")
        p("Examination?")
      p("Hur ska våra **utbildningsprogram** förändras?")
      p("Vilka **risker** finns och hur kan de hanteras?")