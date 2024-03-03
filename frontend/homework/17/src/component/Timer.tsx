import  { useState, useEffect, useRef } from "react";

const Timer = () => {
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

  const timerStyle = {
    textAlign: "center",
    padding: "20px",
    backgroundColor: "#f0f0f0",
    borderRadius: "8px",
    boxShadow: "0 0 10px rgba(0, 0, 0, 0.1)",
    maxWidth: "300px",
    margin: "20px auto",
  };

  const timeTextStyle = {
    fontSize: "24px",
    fontWeight: "bold",
  };

  return (
    <div style={timerStyle}>
      <p style={timeTextStyle}>Elapsed Time: {elapsedTime} seconds</p>
    </div>
  );
};

export default Timer;
