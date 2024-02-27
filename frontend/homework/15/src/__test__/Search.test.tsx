import { fireEvent, render,screen} from '@testing-library/react';
import Header from '../component/Header';
import { Provider } from 'react-redux';
import {  store } from '../redux/Store';

it("should have title of Item-Lister",()=>{
    render(<Provider store={store}>
        <Header/>
        </Provider>)
    const msg = screen.queryByText("Item Lister")
    expect(msg).toBeDefined();
})

it("it should be able to input in search bar",()=>{
    render(<Provider store={store}>
        <Header/>
        </Provider>)


    const inputElement = screen.getByPlaceholderText("Search Items...");

    // Use fireEvent to simulate typing in the input box
    fireEvent.change(inputElement, { target: { value: "Test Value" } });

    const updatedInputElement = screen.getByPlaceholderText("Search Items...") as HTMLInputElement;

    expect(updatedInputElement.value).toBe("Test Value");
})