import { useRef, useEffect } from "react";

function ScrollToTop() {
  const scrollToTopRef = useRef<HTMLDivElement | null>(null);

  useEffect(() => {
    scrollToTopRef.current?.scrollTo(0, 0);
  }, []);

  return (
    <div ref={scrollToTopRef}>
      Lorem ipsum dolor sit amet consectetur adipisicing elit. Qui dolorem odit
      molestias. Ut, ex. Neque ipsa architecto nobis odit sed magni expedita cum
      quidem, ex vitae maxime consequatur, consequuntur dolorem! Nostrum quia
      dolores eligendi eos vero consectetur incidunt quod ipsam tempora sapiente
      quaerat, tempore, quisquam consequatur. Quasi molestiae molestias culpa
      nihil at. Quas sed recusandae excepturi qui dolore? Nemo exercitationem
      doloribus consequatur assumenda? Soluta mollitia dolore labore minus
      explicabo accusantium debitis laboriosam nostrum voluptas incidunt
      exercitationem velit, quam molestias id quasi laborum aliquam rem. Dicta
      harum commodi fugit placeat voluptates, similique doloremque aspernatur
      omnis eum quaerat necessitatibus deserunt! Aliquam amet, laudantium soluta
      sequi ipsa inventore placeat, dignissimos expedita porro accusamus optio,
      nostrum odit dolor blanditiis facere consequuntur officia facilis labore
      doloremque? Incidunt, provident? Quia odit fuga omnis saepe maxime soluta,
      iste nisi suscipit, iure sint asperiores excepturi quos delectus nihil
      est, enim eos rerum voluptates accusamus quasi nobis! Quam, impedit?
      Quisquam eius quas, distinctio aperiam quidem quis inventore, eaque harum
      tenetur, impedit maxime omnis sapiente rem voluptates commodi minima
      tempora totam! Dignissimos deserunt dolore sed animi, alias, cupiditate
      magnam ipsa velit id possimus tempora numquam sint. Distinctio vitae iure
      aliquam omnis. Veniam possimus et dolorum minus assumenda quam praesentium
      harum sint quis soluta! Quod, eaque doloremque illum facilis ab quaerat ea
      cumque quam sequi! Eos odit laborum voluptatem tempore repellendus quam
      vero veritatis architecto cum, possimus aliquid dolorum at consectetur
      nemo ducimus quisquam iure! Incidunt quo quos, quidem harum dolorum
      adipisci! Nihil nostrum odio repellendus recusandae consequuntur tenetur
      eaque nulla, a beatae mollitia aperiam non, dolore aspernatur. Rem
      adipisci asperiores voluptates id totam sed enim esse exercitationem earum
      quibusdam magni quisquam quam a pariatur dolore ipsa perspiciatis minima
      dolor iure, vero, qui officiis fuga? Exercitationem ipsam aliquid quas aut
      quam nemo veritatis consequatur mollitia, modi, optio non inventore
      quaerat. Error magnam, et velit rerum minima dicta laboriosam, vel
      accusantium ullam, numquam reiciendis. Vitae mollitia libero fuga est
      maiores! Velit soluta maiores dolorum, ducimus corrupti eos animi sint. Id
      quis ad ipsam culpa, est itaque iste omnis illum quidem alias sint
      distinctio beatae quo accusantium porro minima dolore fugiat cumque
      consequuntur sequi quisquam fuga! Tenetur, repellendus nam libero modi
      voluptatibus ea delectus dignissimos corrupti fugit eius reprehenderit
      quas impedit dolore saepe sequi repellat consequuntur! Laudantium minus,
      eum quaerat dolorum illo ducimus. Molestiae reiciendis eligendi voluptates
      laborum necessitatibus tempore modi doloremque, odit accusantium esse
      sequi! Necessitatibus, repellat reprehenderit. Ullam non corporis
      mollitia.
    </div>
  );
}

export default ScrollToTop;
