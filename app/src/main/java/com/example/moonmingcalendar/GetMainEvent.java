package com.example.moonmingcalendar;

import java.util.ArrayList;

public class GetMainEvent {
    ArrayList<MainEvent> arrayList = new ArrayList<>();
    ArrayList<ChineseEvent> ChineseList = new ArrayList<>();
    String[] dmy;

    public GetMainEvent(String day){
//        eng
//              1
        arrayList.add(new MainEvent("วันปีใหม่", "วันปีใหม่สากล เป็นวันเริ่มนับ 1 ใหม่ในปีพุทธศักราช และคริสตศักราช ตรงกับวันที่ 1 มกราคม ของทุกๆ ปีโดยยึดวันขึ้นปีใหม่ตาม ปฏิทินเกรโกเรียน ซึ่งเป็นปฏิทินที่ใช้อย่างแพร่หลายในประเทศตะวันตก", "NO", "1", "1"));
//              2
        arrayList.add(new MainEvent("วันวาเลนไทน์", "วันแห่งความรัก วันที่ 14 กุมภาพันธ์ของทุกปี ถูกจัดให้เป็นวันหยุดเพื่อเป็นเกียรติแต่เทพเจ้าจูโน ผู้เป็นจักรพรรดินีแห่งเทพเจ้าโรมัน นอกจากนี้แล้วพระองค์ยังทรงเป็นเทพเจ้าแห่งอิสตรีเพศและการแต่งงาน", "NO", "14", "2"));
//              12
        arrayList.add(new MainEvent("วันคริสต์มาสอีฟ", "วันคริสต์มาสอีฟ เป็นเย็นแรกของวันคริสต์มาส ซึ่งมีการเฉลิมฉลองเพื่อระลึกถึง การประสูติของพระเยซู", "NO", "25", "12"));
        arrayList.add(new MainEvent("วันคริสต์มาส", "วันคริสต์มาส เป็นการฉลองวันประสูติของพระเยซูผู้เป็นศาสดาสูงสุดของชาวคริสต์ทั่วโลก เป็นวันฉลองที่มีความสำคัญ และมีความหมายมากที่สุดวันหนึ่งของชาวคริสต์", "NO", "25", "12"));
//        thai
//              4
        arrayList.add(new MainEvent("วันจักรี", "วันที่ระลึกพระบาทสมเด็จพระพุทธยอดฟ้าจุฬาโลกฯ ปฐมบรมราชวงศ์จักรี เสด็จปราบดาภิเษกขึ้นครองราชย์เป็นกษัตริย์แห่งราชวงศ์จักรี", "NO", "6", "4"));
        arrayList.add(new MainEvent("วันสงกรานต์", "เป็นวันขึ้นปีใหม่ไทย ซึ่งเป็นประเพณีของประเทศไทย ลาว กัมพูชา พม่า ชนกลุ่มน้อยชาวไตแถบเวียดนาม และมนฑลยูนานของจีน รวมถึงศรีลังกา และประเทศทางตะวันออกของประเทศอินเดีย สันนิษฐานกันว่า ประเพณีสงกรานต์นั้นได้รับวัฒนธรรมมาจากเทศกาลโฮลีในอินเดีย", "NO", "13", "4"));
        arrayList.add(new MainEvent("วันสงกรานต์", "เป็นวันขึ้นปีใหม่ไทย ซึ่งเป็นประเพณีของประเทศไทย ลาว กัมพูชา พม่า ชนกลุ่มน้อยชาวไตแถบเวียดนาม และมนฑลยูนานของจีน รวมถึงศรีลังกา และประเทศทางตะวันออกของประเทศอินเดีย สันนิษฐานกันว่า ประเพณีสงกรานต์นั้นได้รับวัฒนธรรมมาจากเทศกาลโฮลีในอินเดีย\"", "NO", "14", "4"));
        arrayList.add(new MainEvent("วันสงกรานต์", "เป็นวันขึ้นปีใหม่ไทย ซึ่งเป็นประเพณีของประเทศไทย ลาว กัมพูชา พม่า ชนกลุ่มน้อยชาวไตแถบเวียดนาม และมนฑลยูนานของจีน รวมถึงศรีลังกา และประเทศทางตะวันออกของประเทศอินเดีย สันนิษฐานกันว่า ประเพณีสงกรานต์นั้นได้รับวัฒนธรรมมาจากเทศกาลโฮลีในอินเดีย\"", "NO", "15", "4"));
//              5
        arrayList.add(new MainEvent("วันฉัตรมงคล", "วพระราชพิธีฉลองพระเศวตฉัตร เป็นวันที่มีพระราชพิธีฉลองพระเศวตฉัตร ซึ่งจะกระทำในวันคล้ายวันบรมราชาภิเษก ซึ่งเป็นโบราณราชประเพณีที่พระมหากษัตริย์ไทยได้รับการสถาปนาอย่างเป็นทางการ ด้วยการถวายน้ำอภิเษก โดยแบ่งออกเป็น 2 พระราชพิธีสำคัญคือ 1.พระราชพิธีบรมราชาภิเษก และ 2.พระราชพิธีเฉลิมพระราชมณเฑียร", "NO", "4", "5"));
        arrayList.add(new MainEvent("วันพืชมงคล", "พระราชพิธิพืชมงคลจรดพระนังคัลแรกนาขวัญ เป็นพิธีกรรม 2 พิธีที่กระทำร่วมกัน คือ 1.พิธีพืชมงคล และ2.พิธีแรกนาขวัญ", "NO", "10", "5"));
//              6
        arrayList.add(new MainEvent("วันเฉลิมฯ พระราชินี", "วันเฉลิมพระชนมพรรษาสมเด็จพระนางเจ้าสิริกิติ์ พระบรมราชินีนาถ พระบรมราชชนนีพันปีหลวง ตรงกับวันที่ 12 สิงหาคม ของทุกปี เป็นวันคล้ายวันพระราชสมภพ", "NO", "3", "6"));
//              7
        arrayList.add(new MainEvent("วันเฉลิมฯ ร.10", "ววันเฉลิมพระชนมพรรษาพระบาทสมเด็จพระปรเมนทรรามาธิบดีศรีสินทรมหาวชิราลงกรณ พระวชิรเกล้าเจ้าอยู่หัว ตรงกับวันที่ 28 กรกฎาคม ของทุกปี เป็นวันคล้ายวันพระราชสมภพ", "NO", "28", "7"));
//              8
        arrayList.add(new MainEvent("วันแม่แห่งชาติ", "วันแม่แห่งชาติ ในประเทศไทย ตรงกับวันที่ 12 สิงหาคม ของทุกปี ซึ่งตรงกับวันคล้ายวันพระราชสมภพของสมเด็จพระนางเจ้าสิริกิติ์ พระบรมราชินีนาถ พระบรมราชชนนีพันปีหลวง", "NO", "12", "8"));
//              9
        arrayList.add(new MainEvent("วันมหิดล", " วันคล้ายวันสวรรคต ของสมเด็จพระมหิตลาธิเบศร อดุลยเดชวิกรม พระบรมราชชนก (สมเด็จฯ เจ้าฟ้ามหิดลอดุลเดช กรมหลวงสงขลานครินทร์) พระบิดาแห่งการแพทย์แผนปัจจุบันและการสาธารณสุขของไทย", "NO", "24", "9"));
//              10
        arrayList.add(new MainEvent("วันคล้ายวันสวรรคต ร.9", "วันคล้ายวันสวรรคต พระบาทสมเด็จพระบรมชนกาธิเบศร มหาภูมิพลอดุลยเดชมหาราช บรมนาถบพิตร", "NO", "13", "10"));
//              12
        arrayList.add(new MainEvent("วันคล้ายวันเฉลิมฯ ร.9", "วันคล้ายวันเฉลิมพระชนมพรรษาของพระบาทสมเด็จพระปรมินทรมหาภูมิพลอดุลยเดช บรมนาถบพิตร (รัชกาลที่ 9) เป็นวันคล้ายวันพระราชสมภพ และเป็นวันพ่อแห่งชาติ", "NO", "5", "12"));
        arrayList.add(new MainEvent("วันรัฐธรรมนูญ", "เป็นวันที่ระลึกถึงโอกาสที่ พระบาทสมเด็จพระปกเกล้าเจ้าอยู่หัว (รัชกาลที่ 7) ที่ทรงพระกรุณาโปรดเกล้าฯ พระราชทานรัฐธรรมนูญแห่งราชอาณาจักรสยาม พุทธศักราช 2475 ซึ่งเป็นรัฐธรรมนูญถาวรฉบับแรกของประเทศไทย", "NO", "10", "12"));
        arrayList.add(new MainEvent("วันพ่อแห่งชาติ", "วันพ่อแห่งชาติ ในประเทศไทย ตรงกับวันที่ 5 ธันวาคม ของทุกปี ซึ่งตรงกับวันคล้ายวันพระราชสมภพของพระบาทสมเด็จพระปรมินทรมหาภูมิพลอดุลยเดช บรมนาถบพิตร", "NO", "5", "12"));
        arrayList.add(new MainEvent("วันสิ้นปี", " วันสุดท้ายของปีซึ่งตรงกับวันที่ 31 ธันวาคม ตามปฏิทินกริกอเรียน ทางการกำหนดให้เป็นวันหยุดราชการ เป็นคืนที่จะมีการจัดงานนับถอยหลังเพื่อเข้าสู่วันขึ้นปีใหม่ในเวลาเที่ยงคืนตามเมืองใหญ่ทั่วโลกซึ่งเกิดขึ้นไม่พร้อมกัน", "NO", "31", "12"));

//       chinese 2021
        ChineseList.add(new ChineseEvent("วันไหว้ส่งเจ้าเสด็จขึ้นสวรรค์","วันส่งเจ้าขึ้นสวรรค์ หรือที่ภาษาจีนเรียกว่า เซ้งเจี่ยที โดยจะตรงกับวันที่ 24 เดือน 12 ของจีน ซึ่งเป็นกำหนดเวลาที่เจ้าเตาจะต้องขึ้นไปรายงานความดี-ชั่วของคนที่อยู่ในบ้านแต่ละหลังให้เง็กเซียนฮ่องเต้บนสรวงสวรรค์ได้ทรงทราบ ทว่าในปัจจุบันนี้คนส่วนใหญ่ได้หันไปไหว้เทพต่าง ๆ แทนการไหว้เจ้าเตาแล้ว แต่ไม่ว่าจะไหว้เทพหรือเจ้าเตา ก็ยังถือเป็นการส่งเจ้าขึ้นสวรรค์เหมือนกัน \\nสิ่งของที่ต้องเตรียมในพิธีไหว้ส่งเจ้าขึ้นสวรรค์นั้นขึ้นอยู่กับความเชื่อของแต่ละบ้าน โดยส่วนใหญ่มักประกอบด้วย \\n- กระถางธูปบรรจุผงธูป- แพแดงและหางนกยูงใหม่ \\n- ธูป 3 หรือ 5 ดอก \\n- แจกันใส่ดอกไม้สดหรือพวงมาลัย \\n- กระทงใส่ค้อซี \\n- ผลไม้ 5 อย่าง \\n- น้ำชา 5 ถ้วย \\n- เสื้อผ้าเทพเจ้า \\n","NO","5","2","2021"));
        ChineseList.add(new ChineseEvent("วันไหว้รับเสด็จเทพเจ้าแห่งโชคลาภไฉ่ซิ้งเอี้ย","วันไหว้เทพเจ้าโชคลาภ ไฉ่ซิงเอี้ย เทพเจ้าแห่งโชคลาภ นับเป็นเทพเจ้าที่ลูกหลานชาวจีนให้ความสำคัญมากที่สุด ในการเริ่มเข้าสู่ปีนักษัตรใหม่ในช่วงตรุษจีน และจะได้รับการกราบไหว้เป็นเทพองค์แรก โดยเชื่อว่า ไฉ่ซิงเอี้ย จะช่วยดลบันดาลความมั่งมีศรีสุข ร่ำรวยโชคลาภ เงินทองไหลมาเทมา \\nของไหว้ไฉ่ซิงเอี้ย \\n- รูปภาพหรือรูปปั้น เทพเจ้าไฉ่ซิงเอี้ย \\n- แจกันดอกไม้สด 1 คู่ \\n- เทียนแดง 1 คู่ \\n- กระถางธูป 1 ใบ \\n- ธูป 3 ดอก ต่อ 1 คน \\n- ผลไม้ 5 สี 5 อย่าง แล้วแต่กำลังทรัพย์ (เช่น องุ่น แอปเปิล กล้วย สาลี่ และส้ม) \\n- สาคูแดงต้มสุก 5 ถ้วย \\n- น้ำชา น้ำสมุนไพร 5 ถ้วย \\n- ข้าวสวย 5 ถ้วย \\n- ขนมจันอับ 1 จาน \\n- เจฉ่าย 5 อย่าง (เช่น เห็ดหอม เห็ดหูหนู ดอกไม้จีน วุ้นเส้น และฟองเต้าหู้) \\n- หงิ่งเตี๋ย 12 ชุด \\n- กิมหงิ่งเต้า 1 คู่ \\n- เทียงเถ้าจี๊ 1 ชุด \\n-กระดาษสีเขียว 1 แผ่น (เทียบเชิญสีเขียว) \\n- เทียบเชิญแดง 1 แผ่น \\n","NO","11","2","2021"));
        ChineseList.add(new ChineseEvent("วันไหว้สิ้นปี","การไหว้วันสิ้นปี หรือ ก๊วยนี้โจ่ย เป็นช่วงคาบเกี่ยวระหว่างสารทที่ 1 กับสารทที่ 8 ถือเป็นวันที่สำคัญวันหนึ่ง วันไหว้วันสุดท้ายของเดือน 12 ก่อนเริ่มปีใหม่ของจีน ตามหลักการไหว้บรรพบุรุษจะตั้งโต๊ะเครื่องบวงสรวงไหว้ในช่วงเช้า โดยเริ่มไหว้จากพระพุทธ ปึงเถ้ากง เทพเจ้าที่ตั้งบูชาในบ้าน ฟ้าดิน เจ้าที่ และบรรพบุรุษ ส่วนการไหว้สัมพเวสีจะไหว้สุดท้าย โดยวางเครื่องบวงสรวงไหว้กับพื้นดิน","NO","11","2","2021"));
        ChineseList.add(new ChineseEvent("วันตรุษจีน","วันตรุษจีนเป็นหนึ่งในเทศกาลที่สำคัญที่สุดของชาวจีน ถือเป็นวันขึ้นปีใหม่ตามปฎิทินจีน ชาวจีนทุกคนให้ความสำคัญกับวันนี้อย่างมาก มีการหยุดงานเป็นเวลายาว โรงเรียนสถาบันการศึกษาปิดเทอม (ปิดเรียนฤดูหนาว)ในช่วงนี้ เหลือเพียงแต่บางอาชีพที่ต้องทำหน้าที่พิเศษ ที่ไม่สามารถหยุดงานได้ ในวันตรุษจีนหน่วยงานห้างร้านต่างจะหยุดงานเป็นเวลา 3-4 วัน เพื่อตระเตรียมจัดงานปีใหม่นี้ \\nอาหารไหว้เจ้า ตรุษจีน \\n- เม็ดบัว มีความหมายถึง การมีลูกหลานที่เป็นชาย \\n- เกาลัด มีความหมายถึง เงิน \\n- สาหร่ายดำ คำของมันออกเสียงคล้าย ความร่ำรวย \\n- เต้าหู้หมักที่ทำจากถั่วแห้ง คำของมันออกเสียงคล้าย เต็มไปด้วยความร่ำรวย และ ความสุข \\n- หน่อไม้ คำของมันออกเสียงคล้าย คำอวยพรให้ทุกอย่างเต็มไปด้วยความสุข เต้าหู้ที่ทำจากถั่วสดนั้นจะไม่นำมารวมกับอาหารในวันนี้เนื่องจากสีขาวซึ่งเป็นสีแห่งโชคร้าย สำหรับปีใหม่และหมายถึงการไว้ทุกข์ \\n- ปลาทั้งตัว เป็นตัวแทนแห่งการอยู่ร่วมกันและความอุดม-สมบรูณ์ \\n- ไก่ สำหรับความเจริญก้าวหน้า ซึ่งไก่นั้นจะต้องยังมีหัว หางและเท้าอยู่ เพื่อเป็นการแสดงให้เห็นถึงความสมบูรณ์ \\n- เส้นหมี่ ไม่ควรตัดเนื่องจากหมายถึงชีวิตที่ยืนยาว \\n","NO","12","2","2021"));
        ChineseList.add(new ChineseEvent("วันไหว้รับเจ้ากลับจากสวรรค์","วันไหว้รับเจ้ากลับจากสวรรค์ ไหว้รับเหล่าเอี๊ยเหลาะที หรือ ซิ้งเลาะที โดยจะต้องกับวันที่ 4 เดือน 1 ตามปฏิทินจัทรคติจีน ชาวจีนเชื่อว่าเทพเจ้าที่เราได้ไหว้ส่งขึ้นสวรรค์ไป จะกลับลงมาสู่โลกมนุษย์ พร้อมรับคำสั่งจากสวรรค์นำคำอวยพร โชคลาภ กลับลงมาด้วย \\nสิ่งของที่ต้องเตรียมในพิธี เช่น ส้ม ขนมจันอับ กระดาษไหว้เจ้า เป็นต้น","NO","15","2","2021"));
        ChineseList.add(new ChineseEvent("วันคล้ายวันเกิดเทพเจ้าไฉ่ซิ้งเอี้ย ปางบู๊","เทพเจ้าไฉ่ซิ้งเอี้ย ปางบู๊ หรือจ้าวกงหมิง เป็นเทพเจ้าแห่งทรัพย์สิน  มักบูชาด้วย ส้ม ซึ่งเป็นผลไม้ที่เป็นสิริมงคล หรือจะถวายน้ำเปล่า หรือน้ำชา เชื่อกันว่าผู้บูชาไฉ่ซิ้งเอี้ยปางบู๊จะเป็นผู้เก็บเงินอยู่ ไม่ไหลออกง่าย โดยองค์ท่านจะช่วยให้ผู้ที่ได้บูชาสามารถที่จะหาเงินได้ง่ายขึ้น หรือเก็บหนี้ได้ง่ายขึ้น","NO","16","2","2021"));
        ChineseList.add(new ChineseEvent("วันคล้ายวันสมภพองค์เทพยดาฟ้าดิน หยี่ว หวังต้าตี้","วันไหว้เทพยดาฟ้าดินทีกงแซ  ตรงกับวันจีนวันที่ 9 เดือน 1 ตามปฏิทินจันทรคติจีน ซึ่งถือว่าเป็นวันทีกงแซ ของชาวจีน หรือที่ เราเรียกว่าเป็นวันเกิดเทพยดาฟ้าดิน คนไทยเชื้อสายจีนจะทำพิธีสักการะเทพยดาฟ้าดินกันในวันนี้ การไหว้ จะไหว้ด้วยส้ม หรือผลไม้มงคลทั่วไป และกระดาษเงินกระดาษทอง หรือกิมจั้ว","NO","20","2","2021"));
        ChineseList.add(new ChineseEvent("ไหว้เทศกาลชาวนา-เทศกาลโคมไฟ","วันที่ 15 เดือน 1 ของจีน จะมีไหว้เรียกว่า ไหว้วันกลางเดือน หรือ เทศกาลโคมไฟ เมื่อไหว้วันนี้เสร็จแล้วจึงจะถึอว่าจบครบถ้วนเทศกาลตรุษจีน โดยคนจีนโบราณเรียกว่า เทศกาลชาวนา (ง่วงเซียวโจ่ย) เพราะวันที่ 16 เดือน 1 ของจีน คือวันที่ชาวนาเริ่มลงนาจริงจัง มีประเพณีแขวนโคมไฟ เซ่นไหว้ขนมผักกาด “ไชเท้าก้วย” และ บัวลอยน้ำขิง","NO","26","2","2021"));
        ChineseList.add(new ChineseEvent("วันคล้ายวันประสูติพระโพธิสัตว์กวนอิม","วันคล้ายวันประสูติพระโพธิสัตว์กวนอิม จะตรงกับวันที่ 19 เดือน 2 ตามปฏิทินจันทรคติจีน พระโพธิสัตว์กวนอิม เดิมเป็นเทพธิดาซึ่งต้องการช่วยปลดเปลื้องทุกข์ภัยแก่มวลมนุษย์  ในชาติสุดท้ายจึงจุติลงมายังโลกมนุษย์นาม เจ้าหญิงเมี่ยวซ่าน เป็นพระราชธิดาองค์เล็กของกษัตริย์แห่งอาณาจักรซิงหลิง พระนามว่า พระเจ้าเมี่ยวจวง กับพระนางเซี่ยวหลิน (พระนางเป๋าเต๋อ)","NO","31","3","2021"));
        ChineseList.add(new ChineseEvent("วันเช็งเม้ง","เทศกาลเช็งเม้งในประเทศจีน เริ่มต้นประมาณวันที่ 4-5 เมษายน ไปจนถึง 19-20 เมษายน เทศกาลเช็งเม้งในไทยจะยึดวันที่ 5 เมษายนของทุกปีคำว่า “เช็งเม้ง” มาจากภาษาจีนกลางว่า ชิงหมิง แปลว่าช่วงเวลาที่อากาศสดชื่น ท้องฟ้าแจ่มใส ประเพณีที่สำคัญมากที่สุดของของชาวจีน คือ ไหว้บรรพบุรุษที่สุสาน โดยมีอิทธิพลมาจากลัทธิขงจื๊อ ที่เน้นเรื่องความกตัญญูเป็นสำคัญ \\nอาหารไหว้เช็งเม้ง ต้องเตรียมอะไรบ้างสำหรับการไหว้บรรพบุรุษ \\n- อาหารคาว ได้แก่ ไก่ต้ม หมูสามชั้นที่มีขนาด ½ กิโลกรัมขึ้นไป เส้นบะหมี่สด \\n- อาหารหวาน ได้แก่ เต่เหลี่ยว ข้าวเหนียวกวน ขนมเต่า (ขนมกู้) ขนมถ้วยฟู (ฮวดโก้ย) น้ำชา \\n- ผลไม้มงคล 5 อย่าง เช่น สัปปะรด กล้วย องุ่น ขนุน ส้ม แอปเปิ้ล \\n- กระดาษเงินกระดาษทอง ธูปเทียน \\n- ของตกแต่งฮวงซุ้ย เช่น ธงประดับหลากสี \\n","NO","4","4","2021"));
        ChineseList.add(new ChineseEvent("วันคล้ายวันประสูติองค์เฮี่ยงเทียงเสี่ยงตี่","วันประสูติองค์เฮี่ยงเทียงเสี่ยงตี่ หรือ เซวียนเทียนสร้างตี้","NO","14","4","2021"));
        ChineseList.add(new ChineseEvent("วันคล้ายวันประสูติเจ้าแม่ทับทิม","วันคล้ายวันประสูติเจ้าแม่ทับทิม หรือ เทียนโหวเซี้ยบ้อ เทพธิดาแห่งท้องทะเล","NO","4","5","2021"));
        ChineseList.add(new ChineseEvent("วันคล้ายวันประสูติองค์ถานกงต้าเซียนเสิ้ง","วันคล้ายวันประสูติองค์ถานกงต้าเซียนเสิ้ง หรือองค์ยุวเทพท่ามกงเยี่ย เมื่อท่านเกิดมานั้น ปรากฏความอุดมสมบูรณ์ของพืชพันธุ์ธัญญาหาร พลิกจากหมู่บ้านที่แห้งแล้งไปในทางที่ดีขึ้น ","NO","19","5","2021"));
        ChineseList.add(new ChineseEvent("วันไหว้บ๊ะจ่าง","เทศกาลไหว้บะจ่าง ตรงกับวันที่ 5 เดือน 5 ตามปฏิทินจันทรคติของจีน สืบทอดมาจาก 2 ประเพณีที่เชื่อมโยงด้วยกัน คือ การบูชาเทพเจ้ามังกรและประเพณีแข่งเรือมังกร","NO","14","6","2021"));
        ChineseList.add(new ChineseEvent("วันคล้ายวันสำเร็จมรรคผลพระโพธิสัตว์กวนอิม","วันคล้ายวันสำเร็จมรรคผลพระโพธิสัตว์กวนอิม ตรงกับวันที่ 19 เดือน 6 ตามปฏิทินจันทรคติจีน ","NO","28","7","2021"));
        ChineseList.add(new ChineseEvent("วันคล้ายวันสมภพองค์ไท้สร้างเหลาจวิน","วันสมภพองค์ไท้ซ่านเหล่าจวิน วันที่ 1 เดือน 7 ตามปฏิทินจันทรคติของจีน","NO","8","8","2021"));
        ChineseList.add(new ChineseEvent("วันคล้ายวันประสูติเทพเจ้ากวนอูฯ","วันคล้ายวันประสูติเทพเจ้ากวนอูฯ หรือ กว้านอี้กง ชาวจีนยังเชื่อว่าการบูชาเทพเจ้ากวนอูจะช่วยนำมาซึ่งความสำเร็จ ความสมหวังดั่งใจนึก โชคลาภก้อนใหญ่ ทั้งช่วยเรียกทรัพย์ โดยเฉพาะอย่างยิ่งการขอพรในเรื่องของการงานและบริวาร","NO","8","8","2021"));
        ChineseList.add(new ChineseEvent("วันสารทจีน","วันสารทจีน หรือจงหยวนเจี๋ย เป็นวันสำคัญที่ลูกหลานชาวจีนจะแสดงความกตัญญูต่อบรรพบุรุษผ่านพิธีเซ่นไหว้ และยังถือเป็นเดือนที่ประตูนรกเปิดให้วิญญาณทั้งหลายมารับกุศลผลบุญได้ ส่วนของไหว้ หลักๆ จะเป็นอาหารคาว อาหารหวาน และผลไม้","NO","22","8","2021"));
        ChineseList.add(new ChineseEvent("วันคล้ายวันเกิดเจ้าแม่ลิ้มกอเหนี่ยว","เรื่องราวของเจ้าแม่ลิ้มกอเหนี่ยวเป็นที่กล่าวขานกันอย่างแพร่หลายในหมู่สังคมชาวจีนในปตานี และเป็นที่มาของการเฉลิมฉลองงานสมโภชเจ้าแม่ลิ้มกอเหนี่ยวเป็นประจำ หลังวันตรุษจีน 15 วันของทุกปี (วันขึ้น 15 ค่ำ เดือนอ้าย ตามจันทรคติของจีน หรือตรงกับวันเพ็ญ เดือน 3 ตามจันทรคติของไทย)","NO","3","9","2021"));
        ChineseList.add(new ChineseEvent("วันไหว้พระจันทร์","วันไหว้พระจันทร์ เป็นเทศกาลตามวัฒนธรรมจีนที่มีขึ้นในกลางฤดูใบไม้ร่วง เพื่อเฉลิมฉลองการเก็บเกี่ยว จะมีขึ้นในคืนวันเพ็ญเดือน 8 ตามปฏิทินจันทรคติ และในเทศกาลไหว้พระจันทร์นี้ ชาวจีนจะเฉลิมฉลองด้วยการไหว้ดวงจันทร์ในเวลากลางคืน ในบางประเทศ เช่น ฮ่องกง, ไต้หวัน, สิงคโปร์ หรือเวียดนาม จะจัดเป็นประเพณีใหญ่ มีการเฉลิมฉลองด้วยโคมไฟสีแดง เป็นสีสันยามค่ำคืน หรือบางแห่งอาจมีการเชิดมังกร ทั้งนี้จะมีชื่อเรียกต่างกันออกไปตามแต่ท้องถิ่น","NO","21","9","2021"));
        ChineseList.add(new ChineseEvent("วันคล้ายวันเกิดเทพเจ้าไฉ่ซิ้งเอี้ย ปางบุ๋น","ไฉ่สิ่งเอี้ย หรือ จ่ายสินเอี้ย เป็นเทพเจ้าของจีนที่ให้คุณทางด้านเงินทองและโชคลาภ (เทพเจ้าแห่งโชคลาภ) ซึ่งสำหรับชาวจีนแล้วถือเป็นเทพเจ้าที่มีความสำคัญมากที่สุด โดยคำว่า \"ไฉ่สิ่ง\" หรือ \"ไฉซิ้ง\" มีความหมายว่า \"ทรัพย์สิน\" หรือ \"สิริมงคล\" \"เอี้ย\" หมายถึง \"เทพเจ้า\" นั่นเอง\nโดยเทพที่ได้รับการนับถือว่าเป็นไฉ่ซิ้งเอี้ย มีด้วยกันหลายองค์ แต่องค์ที่ได้รับการบูชามากที่สุด คือ ปี่กั้น ซึ่งเป็นบุคคลที่มีตัวตนจริงในประวัติศาสตร์ โดยถือว่าเป็น ไฉ่สิ่งเอี้ยฝ่ายบุ๋น ขณะที่จ้าวกงหมิง ถือเป็น ไฉ่สิ่งเอี้ยฝ่ายบู๊","NO","29","9","2021"));
        ChineseList.add(new ChineseEvent("เทศกาลกินเจ","เทศกาลกินเจ หรือบางแห่งเรียกว่า ประเพณีถือศีลกินผัก เป็นประเพณีแบบลัทธิเต๋ารวม 9 วัน กำหนดเอาวันตามจันทรคติ คือ เริ่มต้นตั้งแต่วันขึ้น 1 ค่ำ ถึง ขึ้น 9 ค่ำ เดือน 9 ตามปฏิทินจีนของทุกปี มีจุดเริ่มต้นโดยชาวเปอรานากันในประเทศมาเลเซียและภาคใต้ของประเทศไทย โดยมีตำนานเล่าขานกันหลายตำนาน ปัจจุบัน เทศกาลกินเจจัดขึ้นในประเทศเอเชียตะวันออกเฉียงใต้ ได้แก่ สิงคโปร์ มาเลเซีย และไทย ตลอดจนหมู่เกาะเรียวในอินโดนีเซียและอาจมีในบางประเทศเอเชียซึ่งการกินเจในเดือน 9 นี้ เชื่อกันว่าน่าจะเกิดขึ้นเมื่อราว พ.ศ. 2170 ตรงกับสมัยอาณาจักรอยุธยา","NO","6","10","2021"));
        ChineseList.add(new ChineseEvent("เทศกาลกินเจ","เทศกาลกินเจ หรือบางแห่งเรียกว่า ประเพณีถือศีลกินผัก เป็นประเพณีแบบลัทธิเต๋ารวม 9 วัน กำหนดเอาวันตามจันทรคติ คือ เริ่มต้นตั้งแต่วันขึ้น 1 ค่ำ ถึง ขึ้น 9 ค่ำ เดือน 9 ตามปฏิทินจีนของทุกปี มีจุดเริ่มต้นโดยชาวเปอรานากันในประเทศมาเลเซียและภาคใต้ของประเทศไทย โดยมีตำนานเล่าขานกันหลายตำนาน ปัจจุบัน เทศกาลกินเจจัดขึ้นในประเทศเอเชียตะวันออกเฉียงใต้ ได้แก่ สิงคโปร์ มาเลเซีย และไทย ตลอดจนหมู่เกาะเรียวในอินโดนีเซียและอาจมีในบางประเทศเอเชียซึ่งการกินเจในเดือน 9 นี้ เชื่อกันว่าน่าจะเกิดขึ้นเมื่อราว พ.ศ. 2170 ตรงกับสมัยอาณาจักรอยุธยา","NO","7","10","2021"));
        ChineseList.add(new ChineseEvent("เทศกาลกินเจ","เทศกาลกินเจ หรือบางแห่งเรียกว่า ประเพณีถือศีลกินผัก เป็นประเพณีแบบลัทธิเต๋ารวม 9 วัน กำหนดเอาวันตามจันทรคติ คือ เริ่มต้นตั้งแต่วันขึ้น 1 ค่ำ ถึง ขึ้น 9 ค่ำ เดือน 9 ตามปฏิทินจีนของทุกปี มีจุดเริ่มต้นโดยชาวเปอรานากันในประเทศมาเลเซียและภาคใต้ของประเทศไทย โดยมีตำนานเล่าขานกันหลายตำนาน ปัจจุบัน เทศกาลกินเจจัดขึ้นในประเทศเอเชียตะวันออกเฉียงใต้ ได้แก่ สิงคโปร์ มาเลเซีย และไทย ตลอดจนหมู่เกาะเรียวในอินโดนีเซียและอาจมีในบางประเทศเอเชียซึ่งการกินเจในเดือน 9 นี้ เชื่อกันว่าน่าจะเกิดขึ้นเมื่อราว พ.ศ. 2170 ตรงกับสมัยอาณาจักรอยุธยา","NO","8","10","2021"));
        ChineseList.add(new ChineseEvent("เทศกาลกินเจ","เทศกาลกินเจ หรือบางแห่งเรียกว่า ประเพณีถือศีลกินผัก เป็นประเพณีแบบลัทธิเต๋ารวม 9 วัน กำหนดเอาวันตามจันทรคติ คือ เริ่มต้นตั้งแต่วันขึ้น 1 ค่ำ ถึง ขึ้น 9 ค่ำ เดือน 9 ตามปฏิทินจีนของทุกปี มีจุดเริ่มต้นโดยชาวเปอรานากันในประเทศมาเลเซียและภาคใต้ของประเทศไทย โดยมีตำนานเล่าขานกันหลายตำนาน ปัจจุบัน เทศกาลกินเจจัดขึ้นในประเทศเอเชียตะวันออกเฉียงใต้ ได้แก่ สิงคโปร์ มาเลเซีย และไทย ตลอดจนหมู่เกาะเรียวในอินโดนีเซียและอาจมีในบางประเทศเอเชียซึ่งการกินเจในเดือน 9 นี้ เชื่อกันว่าน่าจะเกิดขึ้นเมื่อราว พ.ศ. 2170 ตรงกับสมัยอาณาจักรอยุธยา","NO","9","10","2021"));
        ChineseList.add(new ChineseEvent("เทศกาลกินเจ","เทศกาลกินเจ หรือบางแห่งเรียกว่า ประเพณีถือศีลกินผัก เป็นประเพณีแบบลัทธิเต๋ารวม 9 วัน กำหนดเอาวันตามจันทรคติ คือ เริ่มต้นตั้งแต่วันขึ้น 1 ค่ำ ถึง ขึ้น 9 ค่ำ เดือน 9 ตามปฏิทินจีนของทุกปี มีจุดเริ่มต้นโดยชาวเปอรานากันในประเทศมาเลเซียและภาคใต้ของประเทศไทย โดยมีตำนานเล่าขานกันหลายตำนาน ปัจจุบัน เทศกาลกินเจจัดขึ้นในประเทศเอเชียตะวันออกเฉียงใต้ ได้แก่ สิงคโปร์ มาเลเซีย และไทย ตลอดจนหมู่เกาะเรียวในอินโดนีเซียและอาจมีในบางประเทศเอเชียซึ่งการกินเจในเดือน 9 นี้ เชื่อกันว่าน่าจะเกิดขึ้นเมื่อราว พ.ศ. 2170 ตรงกับสมัยอาณาจักรอยุธยา","NO","10","10","2021"));
        ChineseList.add(new ChineseEvent("เทศกาลกินเจ","เทศกาลกินเจ หรือบางแห่งเรียกว่า ประเพณีถือศีลกินผัก เป็นประเพณีแบบลัทธิเต๋ารวม 9 วัน กำหนดเอาวันตามจันทรคติ คือ เริ่มต้นตั้งแต่วันขึ้น 1 ค่ำ ถึง ขึ้น 9 ค่ำ เดือน 9 ตามปฏิทินจีนของทุกปี มีจุดเริ่มต้นโดยชาวเปอรานากันในประเทศมาเลเซียและภาคใต้ของประเทศไทย โดยมีตำนานเล่าขานกันหลายตำนาน ปัจจุบัน เทศกาลกินเจจัดขึ้นในประเทศเอเชียตะวันออกเฉียงใต้ ได้แก่ สิงคโปร์ มาเลเซีย และไทย ตลอดจนหมู่เกาะเรียวในอินโดนีเซียและอาจมีในบางประเทศเอเชียซึ่งการกินเจในเดือน 9 นี้ เชื่อกันว่าน่าจะเกิดขึ้นเมื่อราว พ.ศ. 2170 ตรงกับสมัยอาณาจักรอยุธยา","NO","11","10","2021"));
        ChineseList.add(new ChineseEvent("เทศกาลกินเจ","เทศกาลกินเจ หรือบางแห่งเรียกว่า ประเพณีถือศีลกินผัก เป็นประเพณีแบบลัทธิเต๋ารวม 9 วัน กำหนดเอาวันตามจันทรคติ คือ เริ่มต้นตั้งแต่วันขึ้น 1 ค่ำ ถึง ขึ้น 9 ค่ำ เดือน 9 ตามปฏิทินจีนของทุกปี มีจุดเริ่มต้นโดยชาวเปอรานากันในประเทศมาเลเซียและภาคใต้ของประเทศไทย โดยมีตำนานเล่าขานกันหลายตำนาน ปัจจุบัน เทศกาลกินเจจัดขึ้นในประเทศเอเชียตะวันออกเฉียงใต้ ได้แก่ สิงคโปร์ มาเลเซีย และไทย ตลอดจนหมู่เกาะเรียวในอินโดนีเซียและอาจมีในบางประเทศเอเชียซึ่งการกินเจในเดือน 9 นี้ เชื่อกันว่าน่าจะเกิดขึ้นเมื่อราว พ.ศ. 2170 ตรงกับสมัยอาณาจักรอยุธยา","NO","12","10","2021"));
        ChineseList.add(new ChineseEvent("เทศกาลกินเจ","เทศกาลกินเจ หรือบางแห่งเรียกว่า ประเพณีถือศีลกินผัก เป็นประเพณีแบบลัทธิเต๋ารวม 9 วัน กำหนดเอาวันตามจันทรคติ คือ เริ่มต้นตั้งแต่วันขึ้น 1 ค่ำ ถึง ขึ้น 9 ค่ำ เดือน 9 ตามปฏิทินจีนของทุกปี มีจุดเริ่มต้นโดยชาวเปอรานากันในประเทศมาเลเซียและภาคใต้ของประเทศไทย โดยมีตำนานเล่าขานกันหลายตำนาน ปัจจุบัน เทศกาลกินเจจัดขึ้นในประเทศเอเชียตะวันออกเฉียงใต้ ได้แก่ สิงคโปร์ มาเลเซีย และไทย ตลอดจนหมู่เกาะเรียวในอินโดนีเซียและอาจมีในบางประเทศเอเชียซึ่งการกินเจในเดือน 9 นี้ เชื่อกันว่าน่าจะเกิดขึ้นเมื่อราว พ.ศ. 2170 ตรงกับสมัยอาณาจักรอยุธยา","NO","13","10","2021"));
        ChineseList.add(new ChineseEvent("เทศกาลกินเจ","เทศกาลกินเจ หรือบางแห่งเรียกว่า ประเพณีถือศีลกินผัก เป็นประเพณีแบบลัทธิเต๋ารวม 9 วัน กำหนดเอาวันตามจันทรคติ คือ เริ่มต้นตั้งแต่วันขึ้น 1 ค่ำ ถึง ขึ้น 9 ค่ำ เดือน 9 ตามปฏิทินจีนของทุกปี มีจุดเริ่มต้นโดยชาวเปอรานากันในประเทศมาเลเซียและภาคใต้ของประเทศไทย โดยมีตำนานเล่าขานกันหลายตำนาน ปัจจุบัน เทศกาลกินเจจัดขึ้นในประเทศเอเชียตะวันออกเฉียงใต้ ได้แก่ สิงคโปร์ มาเลเซีย และไทย ตลอดจนหมู่เกาะเรียวในอินโดนีเซียและอาจมีในบางประเทศเอเชียซึ่งการกินเจในเดือน 9 นี้ เชื่อกันว่าน่าจะเกิดขึ้นเมื่อราว พ.ศ. 2170 ตรงกับสมัยอาณาจักรอยุธยา","NO","14","10","2021"));
        ChineseList.add(new ChineseEvent("วันประสูติเทพเจ้านาจาซาไท้จื้อฯ","องค์พระนาจาเป็นเซียน ที่ทรงบุญฤทธิ์ และทรงอิทธิฤทธิ์มาก สามารถขับภูติผีปีศาจมารร้ายต่าง ๆ องค์พระนาจาได้สำเร็จเป็นเซียน ในขณะที่ยังมีชีวิตอยู่ในโลกมนุษย์ กล่าวกันว่า องค์พระนาจาเป็นเซียนที่คอยเป็นองครักษ์ของ องค์เง็กเซียนฮ่องเต้ และเป็นแม่ทัพฟ้า บัญชาการทหารฟ้าทั้งสี่ทิศ มีธงสีเหลืองเป็นธงประจำกองทัพ","NO","14","10","2021"));
        ChineseList.add(new ChineseEvent("วันคล้ายวันออกบวชพระโพธิสัตว์กวนอิม","อาเนี่ยแซเป็นวันสำคัญขององค์พระมหาโพธิสัตว์กวนอิม (พระแม่กวนอิม) ในหนึ่งปีจะมีวันอาเนี่ยแซ 3 วัน คือ วันคล้ายวันประสูติ วันคล้ายวันออกบวช และวันคล้ายวันสำเร็จมรรคผล ซึ่งจะตรงกับวันที่ 19 เดือน 2, วันที่ 19 เดือน 9 และวันที่ 19 เดือน 6 ตามปฏิทินจันทรคติจีน","NO","24","10","2021"));
        ChineseList.add(new ChineseEvent("วันไหว้ขนมบัวลอย","\"เทศกาลไหว้ขนมบัวลอย\" หรือ \"เทศกาลตังโจ่ย\" มีความหมายถึง วันเหมายัน คือ วันที่พระอาทิตย์จะส่องแสงสั้นที่สุด หรือ วันที่เป็นจุดสูงสุดในฤดูหนาว (The Extreme of Winter) ","NO","21","12","2021"));

        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","13","1","2021"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","12","2","2021"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","13","3","2021"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","12","4","2021"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","12","5","2021"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","10","6","2021"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","10","7","2021"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","8","8","2021"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","7","9","2021"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","6","10","2021"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","5","11","2021"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","4","12","2021"));

        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","27","1","2021"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","26","2","2021"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","27","3","2021"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","26","4","2021"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","26","5","2021"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","24","6","2021"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","24","7","2021"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","22","8","2021"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","21","9","2021"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","20","10","2021"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","19","11","2021"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","18","12","2021"));

//       chinese 2020
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","25","1","2020"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","23","2","2020"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","24","3","2020"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","23","4","2020"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","23","5","2020"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","21","6","2020"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","21","7","2020"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","19","8","2020"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","17","9","2020"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","17","10","2020"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","15","11","2020"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","15","12","2020"));

        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","9","1","2020"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","8","2","2020"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","8","3","2020"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","7","4","2020"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","7","5","2020"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","6","6","2020"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","5","7","2020"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","4","8","2020"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","2","9","2020"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","1","10","2020"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","31","10","2020"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","29","11","2020"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","29","12","2020"));

//       chinese 2022
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","3","1","2022"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","1","2","2022"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","3","3","2022"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","1","4","2022"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","1","5","2022"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","30","5","2022"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","29","6","2022"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","29","7","2022"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","27","8","2022"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","26","9","2022"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","25","10","2022"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","24","11","2022"));
        ChineseList.add(new ChineseEvent("วันชิวอิก","วันพระจีน","NO","23","12","2022"));

        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","17","1","2022"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","15","2","2022"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","17","3","2022"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","15","4","2022"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","15","5","2022"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","13","6","2022"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","13","7","2022"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","12","8","2022"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","10","9","2022"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","10","10","2022"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","8","11","2022"));
        ChineseList.add(new ChineseEvent("วันจับโหงว","วันพระจีน","NO","8","12","2022"));


        dmy = day.split("/");
    }

    public ArrayList<String> getEventListName(){
        ArrayList<String> eventLst = new ArrayList<>();
        for (int i=0;i<arrayList.size();i++){
            if (dmy[0].equals(arrayList.get(i).getDay()) && dmy[1].equals(arrayList.get(i).getMonth())){
                eventLst.add(arrayList.get(i).getName());
            }
        }
        for (int j=0;j<ChineseList.size();j++){
            if (dmy[0].equals(ChineseList.get(j).getDay()) && dmy[1].equals(ChineseList.get(j).getMonth()) && dmy[2].equals(ChineseList.get(j).getYear())){
                eventLst.add(ChineseList.get(j).getName());
            }
        }
        if (BuddhistHolyDay(dmy)){
            eventLst.add("วันพระ");
        }
        return eventLst;
    }

    public ArrayList<String> getEventListDetail(){
        ArrayList<String> eventLst = new ArrayList<>();
        for (int i=0;i<arrayList.size();i++){
            if (dmy[0].equals(arrayList.get(i).getDay()) && dmy[1].equals(arrayList.get(i).getMonth())){
                eventLst.add(arrayList.get(i).getDetail());
            }
        }
        for (int j=0;j<ChineseList.size();j++){
            if (dmy[0].equals(ChineseList.get(j).getDay()) && dmy[1].equals(ChineseList.get(j).getMonth()) && dmy[2].equals(ChineseList.get(j).getYear())){
                eventLst.add(ChineseList.get(j).getDetail());
            }
        }
        if (BuddhistHolyDay(dmy)){
            eventLst.add("วันพระไทย");
        }

        return eventLst;
    }

    public ArrayList<String> getEventListN(){
        ArrayList<String> eventLst = new ArrayList<>();
        for (int i=0;i<arrayList.size();i++){
            if (dmy[0].equals(arrayList.get(i).getDay()) && dmy[1].equals(arrayList.get(i).getMonth())){
                eventLst.add("");
            }
        }
        for (int j=0;j<ChineseList.size();j++){
            if (dmy[0].equals(ChineseList.get(j).getDay()) && dmy[1].equals(ChineseList.get(j).getMonth()) && dmy[2].equals(ChineseList.get(j).getYear())){
                eventLst.add("");
            }
        }
        if (BuddhistHolyDay(dmy)){
            eventLst.add("");
        }
        return eventLst;
    }

    public boolean BuddhistHolyDay(String[] date){
        int day = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);
        if(month<=2){
            month+=12;
            year-=1;
        }
        double A = Math.floor(year/100);
        double B = 2 - A + Math.floor(A/4);
        double jd = Math.floor(365.25*(year+4716)) + Math.floor(30.6001 * (month +1)) + day + B - 1524.5;
        double ans = (((jd-2454000.98958)/29.530588*4000)%4000)/1000;
        if ((ans<0.25) || (ans>=0.75 && ans<1.25) || (ans>=1.75 && ans<2.25) || (ans>=2.75 && ans<3.25)){
            return true;
        }else{
            return false;
        }

    }

}
