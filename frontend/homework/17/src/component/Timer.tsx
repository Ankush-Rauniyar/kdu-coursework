import { useState, useEffect, useRef } from "react";

function Timer(){
  const [elapsedTime, setElapsedTime] = useState<number>(0);
  const intervalRef = useRef<number | null>(null);

  useEffect(() => {
    intervalRef.current = setInterval(() => {
      setElapsedTime((prevTime) => prevTime + 1);
    }, 1000);

    return () => {
      if (intervalRef.current !== null) {
        clearInterval(intervalRef.current);
      }
    };
  }, []);

  return (
    <div>
      <p>Elapsed Time: {elapsedTime} seconds</p>
    </div>
  );
}

export default Timer;
