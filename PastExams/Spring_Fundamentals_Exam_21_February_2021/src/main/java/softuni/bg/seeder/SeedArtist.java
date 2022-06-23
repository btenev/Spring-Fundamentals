package softuni.bg.seeder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.bg.model.entity.ArtistEntity;
import softuni.bg.model.enums.BandNameEnum;
import softuni.bg.repository.ArtistRepository;

import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class SeedArtist implements CommandLineRunner {
    private final Path QUEEN_INFORMATION = Path.of( "src", "main","resources", "bands", "queen.txt");
    private final Path METALLICA_INFORMATION = Path.of("src", "main","resources", "bands", "metallica.txt");
    private final Path MADONNA_INFORMATION = Path.of("src", "main","resources", "bands", "madonna.txt");

    private final ArtistRepository artistRepository;

    public SeedArtist(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        for (BandNameEnum band : BandNameEnum.values()) {
            ArtistEntity artistEntity = new ArtistEntity();
            artistEntity.setName(band);

            String bandInfo = switch (band) {
                case QUEEN -> Files.readString(QUEEN_INFORMATION);
                case METALLICA -> Files.readString(METALLICA_INFORMATION);
                case MADONNA -> Files.readString(MADONNA_INFORMATION);
            };

            artistEntity.setCareerInformation(bandInfo);

            this.artistRepository.save(artistEntity);
        }
    }
}
