window.onload = () => {
  const images = document.getElementsByTagName('img');
  for(const image of images) {
    image.addEventListener("mouseover", e => {
      const caption = document.getElementById(`${e.target.id}-caption`);
      caption.style.visibility = "hidden";
    });
    image.addEventListener("mouseout", e => {
      const caption = document.getElementById(`${e.target.id}-caption`);
      caption.style.visibility = "";
    });
  }
};



