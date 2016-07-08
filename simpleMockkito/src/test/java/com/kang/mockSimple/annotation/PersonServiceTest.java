package com.kang.mockSimple.annotation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

/**
 * Created by Administrator on 2016/7/5.
 */
public class PersonServiceTest {

    @Mock
    private PersonDAO personDAO;
    private PersonService  personService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks( this );
        personService = new PersonService(personDAO);
    }

    @Test
    public void mockUpdate(){
        Person person = new Person( 1, "Phillip" );
        Mockito.when(personDAO.fetchPerson(1)).thenReturn(person);
        boolean updated = personService.update( 1, "David" );
        Assert.assertTrue(updated);
        Mockito.verify(personDAO).fetchPerson(1);

        //参数捕捉器
        ArgumentCaptor<Person> personCaptor = ArgumentCaptor.forClass( Person.class );
        Mockito.verify( personDAO ).update( personCaptor.capture());

        Person updatedPerson = personCaptor.getValue();
        Assert.assertEquals( "David", updatedPerson.getPersonName() );
        Mockito.verifyNoMoreInteractions( personDAO );
    }

    @Test
    public void returnNull(){
        Mockito.when(personDAO.fetchPerson( 1 )).thenReturn(null);
        boolean update = personService.update(1,"David");
        Assert.assertFalse(update);
        Mockito.verify(personDAO).fetchPerson(1);
        //Mockito.verifyZeroInteractions(personDAO); ///验证mock对象是否有被调用过模拟方法
        //Mockito.verifyNoMoreInteractions(personDAO);//验证mock对象是否有没有被调用过方法
    }

    @Test
    public void interaction() {
        List<String> mock = Mockito.mock(List.class);
        Mockito.when(mock.get(0)).thenReturn("hello");
        mock.get(0);
        mock.get(1);
        mock.get(2);

        Mockito.verify(mock).get(0);
        Mockito.verify(mock).get(1);
        Mockito.verify(mock).get(2); //验证有没有做过get(2)操作
        Mockito.verify(mock, Mockito.never()).get(3);
        Mockito.verifyNoMoreInteractions(mock);//判断是否mock对象的所有操作已经被验证

        List<String> mock2 = Mockito.mock(List.class);
        mock2.get(0);
        Mockito.verify(mock2).get(0);
        Mockito.verifyZeroInteractions(mock2);//判断是否mock对象的所有操作已经被验证  或者从来没有操作

        List<String> mock3 = Mockito.mock(List.class);
        Mockito.verifyZeroInteractions(mock3);//判断是否mock对象的所有操作已经被验证  或者从来没有操作
    }
}
