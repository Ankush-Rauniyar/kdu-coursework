let isLiked = false;
let likesCount = 0;

function toggleLike(button) {
  isLiked = !isLiked;

  const imgElement = button.querySelector('img');

  if (isLiked) {
    imgElement.src = 'post-elements/liked.png'; // Change to the path of your liked image
    likesCount++;
  } else {
    imgElement.src = 'post-elements/like.png'; // Change to the path of your default like image
    likesCount--;
  }

  updateLikesCount(button.parentElement);
}

function updateLikesCount(button) {
  const likesCountElement = button.querySelector('.likes-count');
  likesCountElement.textContent = likesCount;
  if (isLiked == true){
    likesCountElement.style.color = 'red';
  }else{
    likesCountElement.style.color = 'white';
  }
}

function bringTweet() {
  const myDivision = document.getElementById('tweeter'); // Fix the method name
  console.log('clicked');
  toggleMobileButtons();
  hidePosts();
  const toggler = document.getElementById('post-invoker');
  toggler.style.display ='none';
  // const above = document.getElementById('buttons-above');
  myDivision.style.display = 'block';

  const postbutton = document.getElementsByClassName('post-button');
  postbutton[0].style.display='none';

  // above.style.display = (myDivision.style.display === 'none') ? 'block' : 'none';
}

function toggleMobileButtons() {
  const mobileButtons = document.querySelector('.mobile-buttons');
  console.log('clicked');
  mobileButtons.style.display = 'flex';
}

function hidePosts(){
  const mobileButtons = document.querySelector('.posts');
  console.log('clicked');
  mobileButtons.style.display = 'none';
}

function goBackFunction(){
  const myDivision = document.getElementById('tweeter'); // Fix the method name
  console.log('clicked');
  myDivision.style.display = 'none';

  const mobileButtons = document.querySelector('.mobile-buttons');
  console.log('clicked');
  mobileButtons.style.display = 'none';

  const hider = document.querySelector('.posts');
  console.log('clicked');
  hider.style.display = 'flex';
  const toggler = document.getElementById('post-invoker');
  toggler.style.display ='block';
}

function loadnavbar(){
  const myDivision = document.getElementById('nav-mob'); // Fix the method name
  console.log('clicked');
  myDivision.style.display = 'flex'; 

  const hider = document.querySelector('.content-posts');
  console.log('clicked');
  hider.style.display = 'none';

  const toggler = document.getElementById('post-invoker');
  toggler.style.display ='none';
}

function bringAll(){
  const myDivision = document.getElementById('nav-mob'); // Fix the method name
  console.log('clicked');
  myDivision.style.display = 'none'; 

  const hider = document.querySelector('.content-posts');
  console.log('clicked');
  hider.style.display = 'flex';

  const toggler = document.getElementById('post-invoker');
  toggler.style.display ='block';
}

function posttweet(){
  const tweetInput = document.querySelector('.post-input').value;

  if (tweetInput.trim() === '') {
    alert('Please enter a tweet!');
    return;
  }

  const postList = document.querySelector('.post-list');

  // Create a new li element with the necessary HTML structure
  const newTweet = document.createElement('li');
  newTweet.classList.add('post-item');
  newTweet.dataset.postId = generatePostId(); // Set a unique post ID

  newTweet.innerHTML = `
    <div class="profile__pic-post">
        <img src="icons/profilepicture.png">
    </div>

    <div class="post-content">

        <div class="post-written">
            <div class="writer-title">
                <span class="account-name">Nitesh Gupta</span>
                <span class="user-name">@nit_hck - 1s</span>
            </div>
            <div class="actual-content">
                ${tweetInput}
            </div>
        </div>

        <div class="buttons-react">
            <button class="comment"><img src="post-elements/comments.png"></button>
            <button class="retweet"><img src="post-elements/retweet.png"> </button>
            <div class="post-container">
                <button class="like-post" onclick="toggleLike(this)">
                  <img src="post-elements/like.png" alt="Like">
                </button>
                <span class="likes-count" style="font-size: 20px;">0</span>
              </div>
            <button class="stats"><img src="post-elements/stats.png"></button>
            <button class="save"><img src="post-elements/save.png"></button>
        </div>
    </div>

    <div class="third-column">
        <div class="options">
            <img src="post-elements/options.png">
        </div>

        <div class="upload">
            <img src="post-elements/upload.png">
        </div>
    </div>
  `;

  // Append the new tweet to the post list
  postList.insertBefore(newTweet, postList.firstChild);

}

function generatePostId() {
  // Simple function to generate a unique post ID (replace with your own logic if needed)
  return Math.floor(Math.random() * 1000);
}