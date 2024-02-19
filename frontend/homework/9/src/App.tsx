import './App.css';
import user from './data/user.json';
import { Skill } from './Components/Skill';
import { Displayer } from './Components/Displayer';
import { Hobby } from './Components/Hobby';


function App() {
  const current = {
    name:user.name,
    fullName:user.fullName,
    qualification:user.qualification
  };
  return (
    <div>
      <Displayer userItem = {current}/>
      <div className='second-container'>
      <Skill skillArray ={user.skills} />
      <Hobby hobbiesArray={user.hobbies}/>
      </div>
    </div>
  );
}

export default App;
