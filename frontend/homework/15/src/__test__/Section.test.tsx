import { render, screen, fireEvent } from '@testing-library/react';
import userEvent from '@testing-library/user-event';
import { Provider } from 'react-redux';
import { store } from '../redux/Store';
import Section from '../component/Section';

describe('Section Component Tests', () => {
    it('should add a todo on clicking "Submit" button', () => {
        render(
          <Provider store={store}>
            <Section />
          </Provider>
        );
      
        const inputElement = screen.getByTestId('item-input');
        const addButton = screen.getByText('Submit');
    
        userEvent.type(inputElement, 'Test Todo');
    
        fireEvent.click(addButton);
        userEvent.type(inputElement, ' ');
      
        expect(() => screen.getByText('Test Todo'));
      });
      
      

  it('should remove todos on clicking "Remove todos" button', () => {
    render(
      <Provider store={store}>
        <Section />
      </Provider>
    );

    const inputElement = screen.getByTestId('item-input');
    const addButton = screen.getByText('Submit');

    const removeButton = screen.getByText('Remove todos');


    userEvent.type(inputElement, 'Test Todo');

    fireEvent.click(addButton);

    fireEvent.click(removeButton);

    const todoItem = screen.queryByText('Test Todo');
    expect(todoItem).toBeNull();
  });
});
