package com.tuanvo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tuanvo.spring.entities.Vocab;
import com.tuanvo.spring.entities.Word;
import com.tuanvo.spring.entities.WordTopic;
import com.tuanvo.spring.service.IVocabService;
import com.tuanvo.spring.service.IWordService;
import com.tuanvo.spring.service.IWordTopicService;

@SpringBootApplication
public class JapaneseApplication implements CommandLineRunner{
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
		if (wordTopicService.findAll().isEmpty()) {
			System.out.println("hello");
			wordTopicService.saveOrUpdate(new WordTopic("Từ vựng trong nhà máy"));
			wordTopicService.saveOrUpdate(new WordTopic("An toàn thực phẩm"));
			wordTopicService.saveOrUpdate(new WordTopic("Âm nhạc"));
			wordTopicService.saveOrUpdate(new WordTopic("Cảm giác và cảm xúc"));
			wordTopicService.saveOrUpdate(new WordTopic("Côn trùng và bò sát"));
			wordTopicService.saveOrUpdate(new WordTopic("Công nghệ"));
			wordTopicService.saveOrUpdate(new WordTopic("Cơ thể con người"));
		}
		if (wordService.findAll().isEmpty()) {
			for (int i = 1; i <= 20; i++) {
				Word word = new Word();
				word.setTitle("Từ vựng phần " + i);
				word.setPhotoURL("https://images-na.ssl-images-amazon.com/images/I/417zLTa1uqL._SX397_BO1,204,203,200_.jpg");
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
				vocab.setImg("https://thuthuatnhanh.com/wp-content/uploads/2020/09/hinh-anh-anime-girl-lanh-lung-scaled.jpg");
				vocab.setAudio("https://storage.dekiru.vn/Data/2017/08/31/katawakutekkyo-636397873296849216.mp3");
				vocab.setExample("鉄筋組2");
				vocab.setExampleMeaning("alo2");
				vocab.setWord(wordService.findByTitle("Từ vựng phần 2"));
				vocab.setExampleImg("https://i.pinimg.com/originals/b2/21/6b/b2216b2c4492a97590a341d61e8ea27a.jpg");
				vocab.setExampleAudio("https://storage.dekiru.vn/Data/2017/08/31/tansokou-636397873339855302.mp3");
				vocabService.saveOrUpdate(vocab);
			}
			for (int i = 1; i <= 20; i++) {
				Vocab vocab = new Vocab();
				vocab.setKanji("鉄筋組");
				vocab.setKana("てっきんぐみ");
				vocab.setRomaji("tekkingumi");
				vocab.setMeaning("Buộc sắt");
				vocab.setImg("https://i.pinimg.com/736x/25/ec/d0/25ecd03a8122fad2884f3289168d6c10.jpg");
				vocab.setAudio("https://storage.dekiru.vn/Data/2017/08/31/katawakutekkyo-636397873296849216.mp3");
				vocab.setExample("鉄筋組2");
				vocab.setExampleMeaning("alo2");
				vocab.setExampleImg("https://cdn.donmai.us/original/f8/4f/__firo_tate_no_yuusha_no_nariagari_drawn_by_syyn_syyndev__f84f696d2aa8fab1a5322fda791103e2.png");
				vocab.setExampleAudio("https://storage.dekiru.vn/Data/2017/08/31/tansokou-636397873339855302.mp3");
				vocab.setWord(wordService.findByTitle("Từ vựng phần 1"));
				vocabService.saveOrUpdate(vocab);
			}
		}
		
	}

}
