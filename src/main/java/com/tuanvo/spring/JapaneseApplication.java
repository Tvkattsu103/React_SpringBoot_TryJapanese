package com.tuanvo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.tuanvo.spring.entity.Role;
import com.tuanvo.spring.entity.User;
import com.tuanvo.spring.entity.Vocab;
import com.tuanvo.spring.entity.Word;
import com.tuanvo.spring.entity.WordTopic;
import com.tuanvo.spring.service.IRoleService;
import com.tuanvo.spring.service.IService;
import com.tuanvo.spring.service.IVocabService;
import com.tuanvo.spring.service.IWordService;
import com.tuanvo.spring.service.IWordTopicService;
import com.tuanvo.spring.utils.ConstantUtils;

@SpringBootApplication
public class JapaneseApplication implements CommandLineRunner {
	@Autowired
	private IService<User> userService;

	@Autowired
	private IRoleService<Role> roleService;
	
	@Autowired
	private IWordTopicService<WordTopic> wordTopicService;

	@Autowired
	private IWordService<Word> wordService;

	@Autowired
	private IVocabService<Vocab> vocabService;

	public static void main(String[] args) {
		SpringApplication.run(JapaneseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (roleService.findAll().isEmpty()) {
			roleService.saveOrUpdate(new Role(ConstantUtils.ADMIN.toString()));
			roleService.saveOrUpdate(new Role(ConstantUtils.USER.toString()));
		}

		if (userService.findAll().isEmpty()) {
			User user1 = new User();
			user1.setEmail("user@gmail.com");
			user1.setName("Test User");
			user1.setMobile("9787456545");
			user1.setRole(roleService.findByName(ConstantUtils.USER.toString()));
			user1.setPassword(new BCryptPasswordEncoder().encode("user"));
			userService.saveOrUpdate(user1);

			User user2 = new User();
			user2.setEmail("admin@gmail.com");
			user2.setName("Test Admin");
			user2.setMobile("9787456545");
			user2.setRole(roleService.findByName(ConstantUtils.ADMIN.toString()));
			user2.setPassword(new BCryptPasswordEncoder().encode("admin"));
			userService.saveOrUpdate(user2);
		}
		if (wordTopicService.findAll().isEmpty()) {
			wordTopicService.saveOrUpdate(new WordTopic("An toàn thực phẩm"));
			wordTopicService.saveOrUpdate(new WordTopic("Âm nhạc"));
			wordTopicService.saveOrUpdate(new WordTopic("Cảm giác và cảm xúc"));
			wordTopicService.saveOrUpdate(new WordTopic("Côn trùng và bò sát"));
			wordTopicService.saveOrUpdate(new WordTopic("Công nghệ"));
			wordTopicService.saveOrUpdate(new WordTopic("Giao thông"));
			wordTopicService.saveOrUpdate(new WordTopic("Cơ thể con người"));
		}
		if (wordService.findAll().isEmpty()) {
			Word word = new Word();
			word.setTitle("Phương tiện giao thông");
			word.setPhotoURL(
					"https://i.imgur.com/rzDgyHq.jpg");
			word.setQuantity(10);
			word.setTopic(wordTopicService.findByName("Giao thông"));
			wordService.saveOrUpdate(word);
			
			for (int i = 1; i <= 4; i++) {
				word = new Word();
				word.setTitle("Từ vựng phần " + i);
				word.setPhotoURL(
						"https://i.imgur.com/qHDd7GM.jpg");
				word.setQuantity(20);
				word.setTopic(wordTopicService.findByName("Âm nhạc"));
				wordService.saveOrUpdate(word);
			}
		}
		if (vocabService.findAll().isEmpty()) {
			for (int i = 1; i <= 20; i++) {
				Vocab vocab = new Vocab();
				vocab.setKanji("鉄筋組");
				vocab.setKana("てっきんぐみ");
				vocab.setRomaji("tekkingumi");
				vocab.setMeaning("Buộc sắt");
				vocab.setImg(
						"https://i.imgur.com/qHDd7GM.jpg");
				vocab.setAudio("https://storage.dekiru.vn/Data/2017/08/31/katawakutekkyo-636397873296849216.mp3");
				vocab.setExample("鉄筋組2");
				vocab.setExampleMeaning("alo2");
				vocab.setWord(wordService.findByTitle("Từ vựng phần 1"));
				vocab.setExampleImg("https://i.imgur.com/rzDgyHq.jpg");
				vocab.setExampleAudio("https://storage.dekiru.vn/Data/2017/08/31/tansokou-636397873339855302.mp3");
				vocabService.saveOrUpdate(vocab);
			}
			Vocab vocab = new Vocab();
			vocab.setKanji("車");
			vocab.setKana("くるま");
			vocab.setRomaji("kuruma");
			vocab.setMeaning("Ô tô");
			vocab.setImg("https://i.imgur.com/LOzuRCO.png");
			vocab.setAudio("https://storage.dekiru.vn///Data/2017/03/20/kuruma-636256113065875074.mp3");
			vocab.setExample("私の車はトヨタの車です。");
			vocab.setExampleMeaning("Xe của tôi là xe của hãng Toyota");
			vocab.setExampleImg(
					"https://i.imgur.com/eMgr0qV.png");
			vocab.setExampleAudio("https://storage.dekiru.vn/Data/2017/06/29/10-636343316260167042.mp3");
			vocab.setWord(wordService.findByTitle("Phương tiện giao thông"));
			vocabService.saveOrUpdate(vocab);
			
			vocab = new Vocab();
			vocab.setKanji("自転車");
			vocab.setKana("じてんしゃ");
			vocab.setRomaji("jitensha");
			vocab.setMeaning("Xe đạp");
			vocab.setImg("https://i.imgur.com/pnJQXom.png");
			vocab.setAudio("https://storage.dekiru.vn///Data/2017/02/16/jitensha-636228528694116318.mp3");
			vocab.setExample("毎朝、自転車で学校へ行きます。");
			vocab.setExampleMeaning("Hàng sáng tôi đi tới trường bằng xe đạp.");
			vocab.setExampleImg(
					"https://i.imgur.com/crk0ckK.png");
			vocab.setExampleAudio("https://storage.dekiru.vn/Data/2017/06/29/9-636343316259917348.mp3");
			vocab.setWord(wordService.findByTitle("Phương tiện giao thông"));
			vocabService.saveOrUpdate(vocab);
			
			vocab = new Vocab();
			vocab.setKanji("電車");
			vocab.setKana("でんしゃ");
			vocab.setRomaji("densha");
			vocab.setMeaning("Tàu điện");
			vocab.setImg("https://i.imgur.com/wIfloqj.jpg");
			vocab.setAudio("https://storage.dekiru.vn///Data/2017/02/10/densha-636223432288011997.mp3");
			vocab.setExample("電車は３０分ごとに走っている。");
			vocab.setExampleMeaning("Các chuyến tàu chạy cách nhau 30 phút.");
			vocab.setExampleImg(
					"https://i.imgur.com/cHEWR4V.jpg");
			vocab.setExampleAudio("https://storage.dekiru.vn/Data/2017/06/29/6-636343316274439154.mp3");
			vocab.setWord(wordService.findByTitle("Phương tiện giao thông"));
			vocabService.saveOrUpdate(vocab);
			
			vocab = new Vocab();
			vocab.setKanji("バス");
			vocab.setKana("バス");
			vocab.setRomaji("basu");
			vocab.setMeaning("Xe buýt");
			vocab.setImg("https://i.imgur.com/6K4e8fv.jpg");
			vocab.setAudio("https://storage.dekiru.vn///Data/2017/03/20/basu-636256115354789119.mp3");
			vocab.setExample("彼はバスか電車で学校に来る。");
			vocab.setExampleMeaning("Anh ấy đến trường bằng tàu điện hoặc xe buýt.");
			vocab.setExampleImg(
					"https://i.imgur.com/4QtHdFY.jpg");
			vocab.setExampleAudio("https://storage.dekiru.vn/Data/2017/06/29/7-636343316259486936.mp3");
			vocab.setWord(wordService.findByTitle("Phương tiện giao thông"));
			vocabService.saveOrUpdate(vocab);
			
			vocab = new Vocab();
			vocab.setKanji("救急車");
			vocab.setKana("きゅうきゅうしゃ");
			vocab.setRomaji("kyuukyuusha");
			vocab.setMeaning("Xe cấp cứu");
			vocab.setImg("https://i.imgur.com/a9i1IJv.jpg");
			vocab.setAudio("https://storage.dekiru.vn/Data/2017/07/11/kyuukyuusha-636353809614627950.mp3");
			vocab.setExample("救急車を呼んでください。");
			vocab.setExampleMeaning("Hãy gọi xe cấp cứu đi!");
			vocab.setExampleImg(
					"https://i.imgur.com/yoSJGP5.jpg");
			vocab.setExampleAudio("https://storage.dekiru.vn/Data/2017/06/29/1-636343316258906856.mp3");
			vocab.setWord(wordService.findByTitle("Phương tiện giao thông"));
			vocabService.saveOrUpdate(vocab);
			
			vocab = new Vocab();
			vocab.setKanji("船");
			vocab.setKana("ふね");
			vocab.setRomaji("fune");
			vocab.setMeaning("Thuyền");
			vocab.setImg("https://i.imgur.com/b8EVqlH.jpg");
			vocab.setAudio("https://storage.dekiru.vn///Data/2017/03/20/fune-636256117722717189.mp3");
			vocab.setExample("船は西へ向かっています。");
			vocab.setExampleMeaning("Con thuyền đang hướng về phía Tây .");
			vocab.setExampleImg(
					"https://i.imgur.com/dDpTEQs.jpg");
			vocab.setExampleAudio("https://storage.dekiru.vn/Data/2017/06/29/3-636343316259277402.mp3");
			vocab.setWord(wordService.findByTitle("Phương tiện giao thông"));
			vocabService.saveOrUpdate(vocab);
			
			vocab = new Vocab();
			vocab.setKanji("飛行機");
			vocab.setKana("ひこうき");
			vocab.setRomaji("hikouki");
			vocab.setMeaning("Máy bay");
			vocab.setImg("https://i.imgur.com/dwQqwP3.jpg");
			vocab.setAudio("https://storage.dekiru.vn///Data/2017/02/10/hikoki-636223432308172123.mp3");
			vocab.setExample("佐藤さんは今朝、飛行機に乗りました。");
			vocab.setExampleMeaning("Anh Sato đã lên máy bay sáng nay.");
			vocab.setExampleImg(
					"https://i.imgur.com/U693QCP.jpg");
			vocab.setExampleAudio("https://storage.dekiru.vn/Data/2017/06/29/4-636343316289581397.mp3");
			vocab.setWord(wordService.findByTitle("Phương tiện giao thông"));
			vocabService.saveOrUpdate(vocab);
			
			vocab = new Vocab();
			vocab.setKanji("パトカー");
			vocab.setKana("パトカー");
			vocab.setRomaji("patokaa");
			vocab.setMeaning("Xe cảnh sát");
			vocab.setImg("https://i.imgur.com/PAxDul4.jpg");
			vocab.setAudio("https://storage.dekiru.vn/Data/2017/07/11/patokaa-636353809641331876.mp3");
			vocab.setExample("マンションの前にパトカーが止まっています。");
			vocab.setExampleMeaning("Xe cảnh sát đỗ phía trước chung cư.");
			vocab.setExampleImg(
					"https://i.imgur.com/nbj9CZk.jpg");
			vocab.setExampleAudio("https://storage.dekiru.vn/Data/2017/06/29/2-636343316304603672.mp3");
			vocab.setWord(wordService.findByTitle("Phương tiện giao thông"));
			vocabService.saveOrUpdate(vocab);
			
			vocab = new Vocab();
			vocab.setKanji("バイク");
			vocab.setKana("バイク");
			vocab.setRomaji("baiku");
			vocab.setMeaning("Xe mô tô");
			vocab.setImg("https://i.imgur.com/493Xde6.jpg");
			vocab.setAudio("https://storage.dekiru.vn///Data/2017/03/20/baiku-636256114309194513.mp3");
			vocab.setExample("バイクを赤く塗った。");
			vocab.setExampleMeaning("Tôi đã sơn màu đỏ cho chiếc xe mô tô.");
			vocab.setExampleImg(
					"https://i.imgur.com/l8zm9A3.jpg");
			vocab.setExampleAudio("https://storage.dekiru.vn/Data/2017/06/29/8-636343316259706972.mp3");
			vocab.setWord(wordService.findByTitle("Phương tiện giao thông"));
			vocabService.saveOrUpdate(vocab);
			
			vocab = new Vocab();
			vocab.setKanji("タクシー");
			vocab.setKana("タクシー	");
			vocab.setRomaji("takushii");
			vocab.setMeaning("Xe taxi");
			vocab.setImg("https://i.imgur.com/kDAhQNp.png");
			vocab.setAudio("https://storage.dekiru.vn///Data/2017/03/20/takushii-636256116084059371.mp3");
			vocab.setExample("駅の近くにタクシー乗り場があります。");
			vocab.setExampleMeaning("Gần nhà ga có điểm bắt taxi.");
			vocab.setExampleImg(
					"https://i.imgur.com/qz23NeD.png");
			vocab.setExampleAudio("https://storage.dekiru.vn/Data/2017/06/29/5-636343316284580664.mp3");
			vocab.setWord(wordService.findByTitle("Phương tiện giao thông"));
			vocabService.saveOrUpdate(vocab);
		}

	}

}
