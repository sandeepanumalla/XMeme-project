package com.crio.starter.repository;

import java.util.Date;
import java.util.List;
import com.crio.starter.data.Meme;
import com.crio.starter.exchange.MemeDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemeRepository extends MongoRepository<Meme, String> {
    default Meme saveWithDate(Meme meme) {
        meme.setDateCreated(new Date());
        return save(meme);
    }
    boolean existsByUsernameAndCaptionAndUrl (String username, String caption, String url);
    List<MemeDto> findTop100ByOrderByDateCreatedDesc();
}
