import  { useEffect, useRef } from "react";

function FocusOnFirstInput() {
  const containerStyle: React.CSSProperties = {
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
    justifyContent: "center",
    height: "100vh",
    margin: 0,
  };

  const labelStyle: React.CSSProperties = {
    marginBottom: 10,
    textAlign: "center",
  };

  const inputStyle: React.CSSProperties = {
    padding: 8,
    margin: 5,
  };

  const buttonStyle: React.CSSProperties = {
    padding: 10,
    marginTop: 10,
  };

  const firstInputRef = useRef<HTMLInputElement | null>(null);

  useEffect(() => {
    firstInputRef.current?.focus();
  }, []);

  return (
    <form style={containerStyle}>
      <label style={labelStyle}>
        First Input:
        <input ref={firstInputRef} type="text" style={inputStyle} placeholder="First Input" />
      </label>
      <label style={labelStyle}>
        Second Input:
        <input type="text" style={inputStyle} placeholder="Second Input" />
      </label>
      <button type="submit" style={buttonStyle}>
        Submit
      </button>
    </form>
  );
}

export default FocusOnFirstInput;
