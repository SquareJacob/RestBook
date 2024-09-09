package com.example.restservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.restservice.api.model.Book;

@Service
public class BookService {

    private List<Book> bookList;

    public BookService(){
        bookList = new ArrayList<>();
        bookList.add(new Book("Lila Greyson", "Echoes of the Forgotten", "In a dystopian world where memories are traded like currency, a young woman, Eve, discovers a secret vault of forgotten memories that could change the fate of humanity. As she dives deeper, she must decide if uncovering the past is worth the cost of the future.", "2023-02-14", 1));
        bookList.add(new Book("Sebastian Thorn", "The Clockmaker's Daughter", " In 1880s London, a mysterious clockmaker disappears, leaving behind his daughter, Clara, and a ticking masterpiece that controls more than just time. As Clara unravels her father’s secrets, she finds herself on the run from a secret society intent on harnessing the power of the clock for their own gain.", "2019-06-07", 2));
        bookList.add(new Book("Serafina Monroe", "Beneath the Violet Sky", "In a distant galaxy, Lyra, a rebellious starship pilot, discovers an ancient alien artifact on a desolate planet. The artifact holds the key to untold power, but also the potential to destroy the universe. With a tyrannical empire hunting her, Lyra must navigate a dangerous world of intrigue and deception.", "2020-09-21", 3));
        bookList.add(new Book("Gabriel Frost", "Whispers in the Snow", "Set in the icy tundras of Alaska, a small town is haunted by strange occurrences each winter. When investigative journalist Maren Carter arrives to document the strange happenings, she uncovers a chilling conspiracy tied to the town's dark past. The deeper she digs, the more she realizes that some secrets are better left buried in the snow.", "2022-12-03", 4));
        bookList.add(new Book("Evelina Hart", "The Library of Lost Souls", "Hidden deep in the heart of Paris lies a library like no other, where each book holds a lost soul seeking redemption. When orphaned bookbinder Iris stumbles upon it, she unwittingly becomes entangled in an ancient struggle between good and evil. She must learn the true power of stories before they consume her soul.", "2021-05-12", 5));
        bookList.add(new Book("Rowan Wilde", "Through the Crimson Lens", "Photojournalist Sam Winslow is renowned for capturing war zones around the world. But when his latest photograph—a shot of a crimson-tinted battlefield—begins to warp the reality around him, he is pulled into a parallel world where history has gone awry. Sam must navigate this new dimension to find the truth behind the lens.", "2017-08-15", 6));
        bookList.add(new Book("Valeria Castille", "Daughter of the Storm", "Ariadne, the daughter of a powerful sea god, has lived her life in isolation, protecting the mortal world from ancient forces of the deep. When a devastating storm strikes the coast, unleashing long-dormant sea monsters, Ariadne must team up with a human pirate to stop a catastrophic war between land and sea.", "2018-03-09", 7));
        bookList.add(new Book("Nathaniel Rivers", "The Silence Between Stars", "Astronomer Elise Burke has spent her career searching for signs of intelligent life beyond Earth. When she receives a mysterious signal from the farthest reaches of the galaxy, she embarks on a journey to decode its meaning. As the message unfolds, it reveals a truth about humanity’s origins that could shake the foundations of life on Earth.", "2024-01-27", 8));
        bookList.add(new Book("Lyra Montague", "The Cursed King’s Heir", "In a kingdom where magic has been outlawed, Prince Dorian inherits a curse that threatens to destroy him and his people. With time running out, Dorian must seek out the last remaining sorceress in exile to break the curse. Along the way, he uncovers dark secrets about his family and the true origins of the kingdom’s magic.", "2022-30-04", 9));
        bookList.add(new Book("Aiden Blackthorne", "Shadows of the Glass City", "In a futuristic metropolis where society is divided by glass walls, those on the outside live in poverty, while the elite thrive within the gleaming city. A hacker named Cale stumbles upon a conspiracy that could shatter the fragile balance of the city. With the help of an unlikely ally from inside the walls, Cale must risk everything to expose the truth.", "2021-11-11", 10));
    }

    public Optional<Book> getBook(Integer id) {
        Optional<Book> optional = Optional.empty();
        for(Book book: bookList){
            if(id == book.getId()){
                optional = Optional.of(book);
                return optional;
            }
        }
        return optional;
    }

    public List<Book> getBookList(){
        return bookList;
    }

}
